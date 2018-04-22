package com.template.provider.admin.biz;

import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.LoginLog;
import com.template.provider.admin.mapper.LoginLogMapper;
import com.template.common.biz.BaseBiz;

/**
 * 系统登录日志表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:56
 */
@Service
public class LoginLogBiz extends BaseBiz<LoginLogMapper,LoginLog> {
}