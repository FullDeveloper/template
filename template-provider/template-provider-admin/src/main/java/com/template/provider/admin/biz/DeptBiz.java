package com.template.provider.admin.biz;

import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.Dept;
import com.template.provider.admin.mapper.DeptMapper;
import com.template.common.biz.BaseBiz;

/**
 * 系统部门表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:57
 */
@Service
public class DeptBiz extends BaseBiz<DeptMapper,Dept> {
}