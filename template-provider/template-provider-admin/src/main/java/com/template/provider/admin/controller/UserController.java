package com.template.provider.admin.controller;

import com.template.auth.client.config.UserAuthConfig;
import com.template.auth.common.util.JWTHelper;
import com.template.common.context.BaseContextHandler;
import com.template.common.controller.BaseController;
import com.template.common.result.ObjectRestResponse;
import com.template.provider.admin.biz.UserBiz;
import com.template.provider.admin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统用户表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:49
 */

@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz,User> {


    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ObjectRestResponse<User> getUserInfoByToken() throws Exception {
        String token = BaseContextHandler.getToken();
        return baseBiz.getUserInfoByToken(token);
    }

}