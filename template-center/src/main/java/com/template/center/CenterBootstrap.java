package com.template.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 13:20
 * Description:
 */
@EnableEurekaServer
@SpringBootApplication
public class CenterBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(CenterBootstrap.class, args);
    }

}
