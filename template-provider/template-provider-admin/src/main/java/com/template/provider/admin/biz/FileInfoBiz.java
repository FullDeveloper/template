package com.template.provider.admin.biz;

import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.FileInfo;
import com.template.provider.admin.mapper.FileInfoMapper;
import com.template.common.biz.BaseBiz;

/**
 * 系统文件信息表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:48
 */
@Service
public class FileInfoBiz extends BaseBiz<FileInfoMapper,FileInfo> {
}