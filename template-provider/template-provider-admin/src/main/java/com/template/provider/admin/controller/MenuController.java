package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.provider.admin.biz.MenuBiz;
import com.template.provider.admin.entity.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:54
 */

@Controller
@RequestMapping("menu")
public class MenuController extends BaseController<MenuBiz,Menu> {

}