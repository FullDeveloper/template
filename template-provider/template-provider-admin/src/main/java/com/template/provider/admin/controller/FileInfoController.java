package com.template.provider.admin.controller;

import com.template.common.controller.BaseController;
import com.template.provider.admin.biz.FileInfoBiz;
import com.template.provider.admin.entity.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统文件信息表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:48
 */

@Controller
@RequestMapping("fileInfo")
public class FileInfoController extends BaseController<FileInfoBiz,FileInfo> {

}