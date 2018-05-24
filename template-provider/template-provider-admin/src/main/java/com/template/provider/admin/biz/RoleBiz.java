package com.template.provider.admin.biz;

import com.template.common.exception.BaseException;
import com.template.common.result.ObjectRestResponse;
import com.template.provider.admin.entity.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.Role;
import com.template.provider.admin.mapper.RoleMapper;
import com.template.common.biz.BaseBiz;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统角色表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:49
 */
@Service
public class RoleBiz extends BaseBiz<RoleMapper,Role> {

    @Autowired
    private RoleMenuBiz roleMenuBiz;

    public ObjectRestResponse authorizedByRoleId(String menuIds, Long roleId) {

        Role role = selectById(roleId.intValue());
        if(role == null) {
            throw new BaseException("角色信息不存在！");
        }

        String[] menuArray = menuIds.split(",");

        RoleMenu condition = new RoleMenu();
        condition.setRoleId(roleId);

        roleMenuBiz.delete(condition);

        if(menuArray.length > 0){
            for(String mid: menuArray){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(Long.parseLong(mid));
                roleMenuBiz.insert(roleMenu);
            }
        }

        return new ObjectRestResponse();
    }
}