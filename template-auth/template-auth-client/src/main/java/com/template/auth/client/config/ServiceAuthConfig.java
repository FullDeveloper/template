package com.template.auth.client.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * Create By Project Template
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
@Data
public class ServiceAuthConfig {

    private byte[] publicKeyByte;

    @Value("${auth.client.id}")
    private String clientId;
    @Value("${auth.client.secret}")
    private String clientSecret;
    @Value("${auth.client.token-header}")
    private String tokenHeader;
    @Value("${spring.application.name}")
    private String applicationName;



}
