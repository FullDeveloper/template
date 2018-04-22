package com.template.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Create By Project Template
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigCenterBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterBootstrap.class, args);
    }

}
