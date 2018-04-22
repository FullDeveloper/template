package com.template.auth.server.configuration;

import com.template.auth.server.interceptor.ClientTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 15:03
 * Description:
 */
@Configuration
public class FeignConfiguration {

    @Bean
    ClientTokenInterceptor getClientTokenInterceptor(){
        return new ClientTokenInterceptor();
    }

}
