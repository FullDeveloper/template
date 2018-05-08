package com.template.provider.admin.controller;

import com.template.common.bean.TreeNode;
import com.template.common.controller.BaseController;
import com.template.common.result.ObjectRestResponse;
import com.template.common.result.TableResultResponse;
import com.template.common.util.Query;
import com.template.provider.admin.biz.MenuBiz;
import com.template.provider.admin.entity.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:54
 */

@RestController
@RequestMapping("menu")
public class MenuController extends BaseController<MenuBiz, Menu> {

    @RequestMapping(value = "/treeMenu")
    public TableResultResponse<Menu> treeMenu(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<Menu> menuList = baseBiz.getMenuListContainsChildren(query);

        return new TableResultResponse<Menu>(menuList.size(), menuList);
    }

    @RequestMapping(value = "/treeNode")
    public ObjectRestResponse getTreeNode(){

        return new ObjectRestResponse<>(baseBiz.dealWithTreeNode());
    }

}