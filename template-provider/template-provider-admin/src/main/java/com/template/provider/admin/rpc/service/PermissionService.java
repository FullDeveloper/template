package com.template.provider.admin.rpc.service;

import com.template.auth.common.bean.PermissionInfo;
import com.template.auth.common.bean.UserInfo;
import com.template.provider.admin.biz.MenuBiz;
import com.template.provider.admin.biz.UserBiz;
import com.template.provider.admin.entity.Menu;
import com.template.provider.admin.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private MenuBiz menuBiz;

    public UserInfo validate(String username, String password){
        UserInfo info = new UserInfo();
        User user = userBiz.getUserByUsername(username);
        if (password.equals(user.getPassword())) {
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId().toString());
        }
        return info;
    }

    public List<PermissionInfo> getAllPermission() {
        List<Menu> menus = menuBiz.selectListAll();
        List<PermissionInfo> result = new ArrayList<>();
        menu2permission(menus, result);
        return result;
    }

    private void menu2permission(List<Menu> menus, List<PermissionInfo> result) {
        PermissionInfo info;
        for (Menu menu : menus) {
            if (StringUtils.isBlank(menu.getUrl())) {
                menu.setUrl("/" + menu.getCode());
            }
            info = new PermissionInfo();
            info.setCode(menu.getCode());
            info.setType(menu.getType() + "");
            info.setName(menu.getName());
            String uri = menu.getUrl();
            if (!uri.startsWith("/")) {
                uri = "/" + uri;
            }
            info.setUri(uri);
            info.setMethod(menu.getMethod());
            result.add(info
            );
            info.setMenu(menu.getTips());
        }
    }

    public List<PermissionInfo> getPermissionByUsername(String username) {
        User user = userBiz.getUserByUsername(username);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        List<PermissionInfo> result = new ArrayList<PermissionInfo>();
        menu2permission(menus, result);
        return result;

    }
}
