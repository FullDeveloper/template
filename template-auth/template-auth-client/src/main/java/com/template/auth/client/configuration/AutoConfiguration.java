package com.template.auth.client.configuration;

import com.template.auth.client.config.ServiceAuthConfig;
import com.template.auth.client.config.UserAuthConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Create By Project Template
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
@Configuration
@ComponentScan(value = "com.template.auth.client")
public class AutoConfiguration {

    @Bean
    ServiceAuthConfig getServiceAuthConfig(){
        return new ServiceAuthConfig();
    }

    @Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }

}
