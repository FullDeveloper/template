package com.template.gate.zuul.feign;

import com.template.auth.common.bean.PermissionInfo;
import com.template.gate.zuul.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 14:25
 * Description:
 */
@FeignClient(value = "provider-admin",fallback = UserServiceFallback.class)
public interface IUserService {

    @RequestMapping(value="/api/user/un/{username}/permissions",method = RequestMethod.GET)
    List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);

    @RequestMapping(value="/api/permissions",method = RequestMethod.GET)
    List<PermissionInfo> getAllPermissionInfo();

}
