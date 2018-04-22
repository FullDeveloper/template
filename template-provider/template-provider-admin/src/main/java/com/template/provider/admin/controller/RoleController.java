package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.provider.admin.biz.RoleBiz;
import com.template.provider.admin.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统角色表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:49
 */

@Controller
@RequestMapping("role")
public class RoleController extends BaseController<RoleBiz,Role> {

}