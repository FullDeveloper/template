package com.template.gate.zuul;

import com.template.auth.client.EnableAuthClient;
import com.template.gate.ratelimit.config.IUserPrincipal;
import com.template.gate.zuul.config.UserPrincipal;
import com.template.gate.zuul.util.DBLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
        DBLog.getInstance().start();
    }

    @Bean
    @Order(1)
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    @Bean
    @Primary
    public IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
