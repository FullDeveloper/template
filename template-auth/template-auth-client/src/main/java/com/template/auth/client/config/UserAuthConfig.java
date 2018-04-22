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
public class UserAuthConfig {

    @Value(value = "${auth.user.token-header}")
    private String tokenHeader;

    private byte[] publicKeyByte;


}
