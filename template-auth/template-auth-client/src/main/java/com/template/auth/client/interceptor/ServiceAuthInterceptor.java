package com.template.auth.client.interceptor;


import com.template.auth.client.annotation.IgnoreClient;
import com.template.auth.client.config.ServiceAuthConfig;
import com.template.auth.client.jwt.ServiceAuthUtil;
import com.template.auth.common.bean.IJWTInfo;
import com.template.common.exception.auth.ClientForbiddenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Create By Project Template
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
@Slf4j
public class ServiceAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private ServiceAuthUtil serviceAuthUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("accept client request ，Begin deal with......");
        HandlerMethod handle = (HandlerMethod) handler;
        IgnoreClient ignoreClient = handle.getBeanType().getAnnotation(IgnoreClient.class);
        if(ignoreClient == null){
            ignoreClient = handle.getMethodAnnotation(IgnoreClient.class);
        }
        if(ignoreClient != null){
            log.info("execute method " + handle.getMethod().getName() + " is ignore..");
            return super.preHandle(request, response, handler);
        }
        log.info("need authentication.......");
        String token = request.getHeader(serviceAuthConfig.getTokenHeader());
        IJWTInfo informationToken = serviceAuthUtil.getInformationToken(token);
        String uniqueName = informationToken.getUniqueName();
        List<String> allowedClients = serviceAuthUtil.getAllowedClient();
        for(String client : allowedClients){
            if(client.equals(uniqueName)){
                log.info("client unique name is allowed: " + client );
                return super.preHandle(request, response, handler);
            }
        }
        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
