package com.template.provider.admin.biz;

import com.template.common.bean.TreeNode;
import com.template.common.util.CollectionUtil;
import com.template.common.util.Query;
import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.Menu;
import com.template.provider.admin.mapper.MenuMapper;
import com.template.common.biz.BaseBiz;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:54
 */
@Service
public class MenuBiz extends BaseBiz<MenuMapper,Menu> {


    public List<Menu> getMenuListContainsChildren(Query query){
        List<Menu> menus = selectListAll();
        List<Menu> parentList = new ArrayList<>();
        for(int i=0; i< menus.size();i++){
            if("0".equals(menus.get(i).getPcode())){
                parentList.add(menus.get(i));
                menus.remove(i);
                i--;
            }
        }
        dealWithChildrenMenu(menus,parentList);
        return parentList;
    }

    private void dealWithChildrenMenu(List<Menu> menus, List<Menu> parentList) {
        for(Menu parent:parentList){
            for(int i=0; i< menus.size();i++){
                if(parent.getCode().equals(menus.get(i).getPcode())){
                    List<Menu> subMenus = parent.getChildren() == null ? new ArrayList<>() : parent.getChildren();
                    subMenus.add(menus.get(i));
                    menus.remove(i);
                    i--;
                    dealWithChildrenMenu(menus,subMenus);
                }
            }
        }
    }

    public List<TreeNode> dealWithTreeNode(){
        List<TreeNode> treeNodes = new ArrayList<>();
        //获取所有的菜单节点
        List<Menu> menus = this.getMenuListContainsChildren(null);

        //将其转换成树形节点
        dealWithMenusToTreeNode(menus,treeNodes);

        return treeNodes;
    }

    private void dealWithMenusToTreeNode(List<Menu> menus, List<TreeNode> treeNodes) {
        for(Menu menu: menus){
            TreeNode treeNode = new TreeNode();
            treeNode.setId(menu.getCode());
            treeNode.setLabel(menu.getName());
            treeNodes.add(treeNode);
            if(!CollectionUtil.isEmpty(menu.getChildren())){
                dealWithMenusToTreeNode(menu.getChildren(), treeNode.getChildren());
            }
        }
    }


}