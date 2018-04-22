package com.template.auth.server.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/4/5 0005
 * Time: 3:04
 * Description:
 */
@Configuration
@Data
public class UserConfiguration {

    @Value("${jwt.token-header}")
    private String userTokenHeader;

}
