package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.provider.admin.biz.RoleMenuBiz;
import com.template.provider.admin.entity.RoleMenu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统角色菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:50
 */

@Controller
@RequestMapping("roleMenu")
public class RoleMenuController extends BaseController<RoleMenuBiz,RoleMenu> {

}