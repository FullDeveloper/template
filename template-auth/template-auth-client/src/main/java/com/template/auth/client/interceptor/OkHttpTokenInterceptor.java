package com.template.auth.client.interceptor;

import com.template.auth.client.config.ServiceAuthConfig;
import com.template.auth.client.config.UserAuthConfig;
import com.template.auth.client.jwt.ServiceAuthUtil;
import com.template.common.bean.LogInfo;
import com.template.common.constant.CommonConstants;
import com.template.common.context.BaseContextHandler;
import lombok.extern.java.Log;
import okhttp3.*;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;


/**
 * @author zrb
 */
@Component
@Log
public class OkHttpTokenInterceptor implements Interceptor {
    @Autowired
    @Lazy
    private ServiceAuthUtil serviceAuthUtil;
    @Autowired
    @Lazy
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    @Lazy
    private UserAuthConfig userAuthConfig;

    private static final Charset UTF8 = Charset.forName("UTF-8");


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = null;
        if (chain.request().url().toString().contains("client/token")) {
            newRequest = chain.request()
                    .newBuilder()
                    .header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken())
                    .build();
        } else {
            newRequest = chain.request()
                    .newBuilder()
                    .header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken())
                    .header(serviceAuthConfig.getTokenHeader(), serviceAuthUtil.getClientToken())
                    .build();
        }
        Response response = chain.proceed(newRequest);
        if (HttpStatus.FORBIDDEN.value() == response.code()) {
            if (response.body().string().contains(String.valueOf(CommonConstants.EX_CLIENT_INVALID_CODE))) {
                log.info("Client Token Expire,Retry to request...");
                serviceAuthUtil.refreshClientToken();
                newRequest = chain.request()
                        .newBuilder()
                        .header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken())
                        .header(serviceAuthConfig.getTokenHeader(), serviceAuthUtil.getClientToken())
                        .build();
                response = chain.proceed(newRequest);
            }
        }
        Object object = BaseContextHandler.get(CommonConstants.LOG_INFO_NAME);
        if (object != null) {
            ResponseBody responseBody = response.body();
            long contentLength = responseBody.contentLength();
            //注意 >>>>>>>>> okhttp3.4.1这里变成了 !HttpHeader.hasBody(response)
            //if (!HttpEngine.hasBody(response)) {
            if (!HttpHeaders.hasBody(response)) {
                //END HTTP
            } else if (bodyEncoded(response.headers())) {
                //HTTP (encoded body omitted)
            } else {
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                Buffer buffer = source.buffer();

                Charset charset = UTF8;
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(UTF8);
                    } catch (UnsupportedCharsetException e) {
                        //Couldn't decode the response body; charset is likely malformed.
                        return response;
                    }
                }

                if (!isPlaintext(buffer)) {
                    log.info("<-- END HTTP (binary " + buffer.size() + "-byte body omitted)");
                    return response;
                }

                if (contentLength != 0) {
                    String result = buffer.clone().readString(charset);
                    log.info("logInfo ==> {exists}");
                    LogInfo logInfo = (LogInfo) object;
                    logInfo.setSuccessStatus(Long.parseLong(response.code() + ""));
                    logInfo.setResult(result);
                    //获取到response的body的string字符串
                    //do something .... <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                }
                log.info("<-- END HTTP (" + buffer.size() + "-byte body)");
            }
        }
        return response;
    }


    static boolean isPlaintext(Buffer buffer) throws EOFException {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }


    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }

}
