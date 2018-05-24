package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.common.result.ObjectRestResponse;
import com.template.provider.admin.biz.MenuBiz;
import com.template.provider.admin.biz.RoleBiz;
import com.template.provider.admin.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统角色表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:49
 */

@Controller
@RequestMapping("role")
public class RoleController extends BaseController<RoleBiz, Role> {

    @Autowired
    private MenuBiz menuBiz;

    @RequestMapping(value = "/getAuthorizedTree")
    @ResponseBody
    public ObjectRestResponse getAuthorizedTree(Long roleId) {
        return menuBiz.authorizedTree(roleId);
    }


    @RequestMapping(value = "/authorizedByRoleId")
    @ResponseBody
    public ObjectRestResponse authorizedByRoleId(String menuIds, Long roleId) {
        return baseBiz.authorizedByRoleId(menuIds,roleId);
    }

}