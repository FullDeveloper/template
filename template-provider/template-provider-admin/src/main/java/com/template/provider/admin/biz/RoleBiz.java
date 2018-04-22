package com.template.provider.admin.biz;

import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.Role;
import com.template.provider.admin.mapper.RoleMapper;
import com.template.common.biz.BaseBiz;

/**
 * 系统角色表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:49
 */
@Service
public class RoleBiz extends BaseBiz<RoleMapper,Role> {
}