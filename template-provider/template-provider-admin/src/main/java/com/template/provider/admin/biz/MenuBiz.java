package com.template.provider.admin.biz;

import com.template.common.bean.TreeNode;
import com.template.common.result.ObjectRestResponse;
import com.template.common.util.CollectionUtil;
import com.template.common.util.Query;
import com.template.provider.admin.entity.Role;
import com.template.provider.admin.entity.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.Menu;
import com.template.provider.admin.mapper.MenuMapper;
import com.template.common.biz.BaseBiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:54
 */
@Service
public class MenuBiz extends BaseBiz<MenuMapper, Menu> {

    @Autowired
    private RoleBiz roleBiz;

    @Autowired
    private RoleMenuBiz roleMenuBiz;

    public List<Menu> getMenuListContainsChildren(Query query) {
        List<Menu> menus = selectListAll();
        List<Menu> parentList = new ArrayList<>();
        for (int i = 0; i < menus.size(); i++) {
            if ("0".equals(menus.get(i).getPcode())) {
                parentList.add(menus.get(i));
                menus.remove(i);
                i--;
            }
        }
        dealWithChildrenMenu(menus, parentList);
        return parentList;
    }

    //将菜单列表中的所有菜单转换成树形结构
    public List<TreeNode> dealWithTreeNode() {
        List<TreeNode> treeNodes = new ArrayList<>();
        //获取所有的菜单节点
        List<Menu> menus = this.getMenuListContainsChildren(null);

        //将其转换成树形节点
        dealWithMenusToTreeNode(menus, treeNodes);

        return treeNodes;
    }

    /**
     * @param roleId
     * @return
     */
    public ObjectRestResponse authorizedTree(Long roleId) {

        //查询出这个角色拥有的所有菜单信息.
        RoleMenu query = new RoleMenu();
        query.setRoleId(roleId);
        List<RoleMenu> roleMenus = roleMenuBiz.selectList(query);

        //获取所有的菜单节点
        List<TreeNode> treeNodes = dealWithTreeNode();
        List<String> defaultValue = new ArrayList<>();
        dealWithDefaultValue(treeNodes, roleMenus, defaultValue);
        ObjectRestResponse<Map<String, Object>> response = new ObjectRestResponse<>();
        Map<String, Object> map = new HashMap<>();
        map.put("defaultValue", defaultValue);
        map.put("authorizedTree", treeNodes);
        response.setData(map);
        return response;
    }


    private void dealWithDefaultValue(List<TreeNode> treeNodes, List<RoleMenu> roleMenus, List<String> defaultValue) {
        for (TreeNode treeNode : treeNodes) {
            if (CollectionUtil.isNotEmpty(treeNode.getChildren())) {
                dealWithDefaultValue(treeNode.getChildren(), roleMenus, defaultValue);
            }
            for (RoleMenu roleMenu : roleMenus) {
                if (treeNode.getId().equals(String.valueOf(roleMenu.getMenuId()))) {
                    defaultValue.add(treeNode.getId());
                }
            }
        }
    }

    /**
     * 获取用户可以访问的菜单
     *
     * @param id
     * @return
     */
    public List<Menu> getUserAuthorityMenuByUserId(int id) {

        return mapper.selectAuthorityMenuByUserId(id);
    }

    private void dealWithMenusToTreeNode(List<Menu> menus, List<TreeNode> treeNodes) {
        for (Menu menu : menus) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(menu.getId() + "");
            treeNode.setLabel(menu.getName());
            treeNodes.add(treeNode);
            if (!CollectionUtil.isEmpty(menu.getChildren())) {
                dealWithMenusToTreeNode(menu.getChildren(), treeNode.getChildren());
            }
        }
    }

    private void dealWithChildrenMenu(List<Menu> menus, List<Menu> parentList) {
        for (Menu parent : parentList) {
            for (int i = 0; i < menus.size(); i++) {
                if (parent.getCode().equals(menus.get(i).getPcode())) {
                    List<Menu> subMenus = parent.getChildren() == null ? new ArrayList<>() : parent.getChildren();
                    subMenus.add(menus.get(i));
                    menus.remove(i);
                    i--;
                    dealWithChildrenMenu(menus, subMenus);
                }
            }
        }
    }
}