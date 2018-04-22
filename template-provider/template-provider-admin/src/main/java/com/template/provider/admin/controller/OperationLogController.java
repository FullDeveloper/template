package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.provider.admin.biz.OperationLogBiz;
import com.template.provider.admin.entity.OperationLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统操作日志
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:52
 */

@Controller
@RequestMapping("operationLog")
public class OperationLogController extends BaseController<OperationLogBiz,OperationLog> {

}