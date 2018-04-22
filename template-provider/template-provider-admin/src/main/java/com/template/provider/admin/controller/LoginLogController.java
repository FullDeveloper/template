package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.provider.admin.biz.LoginLogBiz;
import com.template.provider.admin.entity.LoginLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统登录日志表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:56
 */

@Controller
@RequestMapping("loginLog")
public class LoginLogController extends BaseController<LoginLogBiz,LoginLog> {

}