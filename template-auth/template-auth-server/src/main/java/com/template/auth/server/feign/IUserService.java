package com.template.auth.server.feign;

import com.template.auth.common.bean.UserInfo;
import com.template.auth.server.bean.JwtAuthenticationRequest;
import com.template.auth.server.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create By Project Pcc_Microservice
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
@FeignClient(value = "provider-admin",configuration = FeignConfiguration.class)
public interface IUserService {

    @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
    UserInfo validate(@RequestBody JwtAuthenticationRequest authenticationRequest);
}
