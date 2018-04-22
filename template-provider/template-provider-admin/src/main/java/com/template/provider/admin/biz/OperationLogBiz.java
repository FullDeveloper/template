package com.template.provider.admin.biz;

import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.OperationLog;
import com.template.provider.admin.mapper.OperationLogMapper;
import com.template.common.biz.BaseBiz;

/**
 * 系统操作日志
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:52
 */
@Service
public class OperationLogBiz extends BaseBiz<OperationLogMapper,OperationLog> {
}