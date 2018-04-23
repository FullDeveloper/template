package com.template.provider.admin.biz;

import com.template.auth.client.config.UserAuthConfig;
import com.template.auth.common.bean.IJWTInfo;
import com.template.auth.common.bean.JWTInfo;
import com.template.auth.common.bean.UserInfo;
import com.template.auth.common.util.JWTHelper;
import com.template.common.result.BaseResponse;
import com.template.common.result.ObjectRestResponse;
import com.template.common.util.CastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.User;
import com.template.provider.admin.mapper.UserMapper;
import com.template.common.biz.BaseBiz;

/**
 * 系统用户表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:49
 */
@Service
public class UserBiz extends BaseBiz<UserMapper,User> {

    @Autowired
    private UserAuthConfig userAuthConfig;

    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }

    public ObjectRestResponse<User> getUserInfoByToken(String token) throws Exception {
        IJWTInfo userInfo = JWTHelper.getInfoFromToken(token,userAuthConfig.getPublicKeyByte());
        return new ObjectRestResponse<>(selectById(CastUtil.castInt(userInfo.getId())));
    }

    public ObjectRestResponse newUserInsert(User user){

        return null;
    }


}