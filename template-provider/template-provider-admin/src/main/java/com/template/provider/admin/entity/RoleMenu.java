package com.template.provider.admin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 系统角色菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:50
 */
@Table(name = "sys_role_menu")
public class RoleMenu implements Serializable{
private static final long serialVersionUID=1L;

        //
    @Id
    private Integer id;
    
        //角色编号
    @Column(name = "role_id")
    private Long roleId;
    
        //菜单编号
    @Column(name = "menu_Id")
    private Long menuId;
    

    /**
     * 设置：
     */
    public void setId(Integer id) {
            this.id = id;
    }
    /**
     * 获取：
     */
    public Integer getId() {
            return id;
    }
    /**
     * 设置：角色编号
     */
    public void setRoleId(Long roleId) {
            this.roleId = roleId;
    }
    /**
     * 获取：角色编号
     */
    public Long getRoleId() {
            return roleId;
    }
    /**
     * 设置：菜单编号
     */
    public void setMenuId(Long menuId) {
            this.menuId = menuId;
    }
    /**
     * 获取：菜单编号
     */
    public Long getMenuId() {
            return menuId;
    }
}