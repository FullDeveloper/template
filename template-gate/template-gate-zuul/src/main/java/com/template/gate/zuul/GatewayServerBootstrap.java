package com.template.gate.zuul;

import com.template.auth.client.EnableAuthClient;
import com.template.gate.ratelimit.config.IUserPrincipal;
import com.template.gate.zuul.config.UserPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 14:21
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthClient
@EnableZuulProxy
@EnableFeignClients({"com.template.auth.client.feign", "com.template.gate.zuul.feign"})
public class GatewayServerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerBootstrap.class, args);
    }


    @Bean
    @Primary
    public IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
