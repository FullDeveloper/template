package com.template.provider.admin;

import com.template.auth.client.EnableAuthClient;
import com.template.cache.EnableCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 15:18
 * Description:
 */
@SpringBootApplication
@MapperScan("com.template.provider.admin.mapper")
@EnableTransactionManagement
@EnableFeignClients({"com.template.auth.client.feign"})
//@EnableAuthClient
@RestController
@EnableCache
public class ProviderAdminBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminBootstrap.class, args);
    }

    @RequestMapping(value = "/hi")
    public String helloAdmin(){

        return "hello Admin";
    }

}
