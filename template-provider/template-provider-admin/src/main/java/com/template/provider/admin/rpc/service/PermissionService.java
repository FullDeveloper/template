package com.template.provider.admin.rpc.service;

import com.template.auth.common.bean.UserInfo;
import com.template.provider.admin.biz.UserBiz;
import com.template.provider.admin.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By Project template
 *
 * @author zrb
 * @date 2018/4/22
 * description
 */
@Service
public class PermissionService {

    @Autowired
    private UserBiz userBiz;

    public UserInfo validate(String username, String password){
        UserInfo info = new UserInfo();
        User user = userBiz.getUserByUsername(username);
        if (password.equals(user.getPassword())) {
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId().toString());
        }
        return info;
    }

}
