package com.template.provider.admin.biz;

import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.Menu;
import com.template.provider.admin.mapper.MenuMapper;
import com.template.common.biz.BaseBiz;

/**
 * 系统菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:54
 */
@Service
public class MenuBiz extends BaseBiz<MenuMapper,Menu> {
}