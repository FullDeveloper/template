package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.provider.admin.biz.DeptBiz;
import com.template.provider.admin.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统部门表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:57
 */

@Controller
@RequestMapping("dept")
public class DeptController extends BaseController<DeptBiz,Dept> {

}