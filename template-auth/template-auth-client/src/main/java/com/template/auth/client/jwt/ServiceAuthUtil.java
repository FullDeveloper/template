package com.template.auth.client.jwt;

import com.template.auth.client.config.ServiceAuthConfig;
import com.template.auth.client.feign.ServiceAuthFeign;
import com.template.auth.common.bean.IJWTInfo;
import com.template.auth.common.util.JWTHelper;
import com.template.common.exception.auth.ClientTokenException;
import com.template.common.result.BaseResponse;
import com.template.common.result.ObjectRestResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * Create By Project Pcc_Microservice
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
@Configuration
@EnableScheduling
@Slf4j
public class ServiceAuthUtil {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthFeign serviceAuthFeign;

    private List<String> allowedClient;

    private String clientToken;

    public IJWTInfo getInformationToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token,serviceAuthConfig.getPublicKeyByte());
        } catch (ExpiredJwtException e) {
            throw new ClientTokenException("Client token expired!");
        }catch (SignatureException e){
            throw new ClientTokenException("Client token signature error!");
        }catch (IllegalArgumentException e){
            throw new ClientTokenException("Client token is null or empty!");
        }
    }

    public String getClientToken() {
        if (this.clientToken == null) {
//            this.refreshClientToken();
        }
        return clientToken;
    }

    @Scheduled(cron = "0 0/10 * * * ?")
    public void refreshClientToken() {
        log.debug("refresh client token.....");
        BaseResponse resp = serviceAuthFeign.getAccessToken(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
            this.clientToken = clientToken.getData();
        }
    }

    public List<String> getAllowedClient() {
        if (this.allowedClient == null) {
            this.refreshAllowedClient();
        }
        return allowedClient;
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void refreshAllowedClient() {
        log.info("refresh allowedClient .....");
        BaseResponse resp = serviceAuthFeign.getAllowedClient(serviceAuthConfig.getClientId(),serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
            this.allowedClient = allowedClient.getData();
        }
    }

}
