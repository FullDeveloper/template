package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.provider.admin.biz.NoticeBiz;
import com.template.provider.admin.entity.Notice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统通知表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:53
 */

@Controller
@RequestMapping("notice")
public class NoticeController extends BaseController<NoticeBiz,Notice> {

}