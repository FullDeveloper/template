package com.template.provider.admin.controller;

import com.template.auth.client.config.UserAuthConfig;
import com.template.auth.common.bean.PermissionInfo;
import com.template.auth.common.util.JWTHelper;
import com.template.common.context.BaseContextHandler;
import com.template.common.controller.BaseController;
import com.template.common.result.ObjectRestResponse;
import com.template.provider.admin.biz.UserBiz;
import com.template.provider.admin.entity.User;
import com.template.provider.admin.rpc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * 系统用户表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:49
 */

@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz, User> {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ObjectRestResponse<User> getUserInfoByToken() throws Exception {
        String token = BaseContextHandler.getToken();
        return baseBiz.getUserInfoByToken(token);
    }

    @RequestMapping(value = "/newUserInsert", method = RequestMethod.POST)
    public ObjectRestResponse newUserInsert(@Validated @RequestBody User user, BindingResult result) {
        ObjectRestResponse restResponse = new ObjectRestResponse();
        if (result.hasErrors()) {
            restResponse.setStatus(400);
            restResponse.setMessage(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            return restResponse;
        }
        return baseBiz.newUserInsert(user);
    }

    @RequestMapping(value = "/un/{username}/resources", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse getPermissionByUsername(@PathVariable("username") String username) {
        return baseBiz.getPermissionByUsername(username);
    }

}