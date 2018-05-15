package com.template.provider.admin.entity;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * 系统菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:54
 */
@Table(name = "sys_menu")
public class Menu implements Serializable{
private static final long serialVersionUID=1L;


    @Transient
    private List<Menu> children = new ArrayList<>();

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    //
    @Id
    private Integer id;
    
        //菜单名称
    @Column(name = "name")
    private String name;
    
        //菜单图标
    @Column(name = "icon")
    private String icon;
    
        //请求地址
    @Column(name = "url")
    private String url;
    
        //菜单层级
    @Column(name = "level")
    private Long level;
    
        //菜单类型0菜单1按钮2后台api权限
    @Column(name = "type")
    private Long type;
    
        //菜单编号
    @Column(name = "code")
    private String code;
    
        //父级菜单编号
    @Column(name = "pcode")
    private String pcode;
    
        //排序字段
    @Column(name = "sort")
    private Long sort;
    
        //菜单状态0禁用 1启用
    @Column(name = "status")
    private Long status;
    
        //提示信息

    @Column(name = "tips")
    private String tips;

    //请求方式
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

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
     * 设置：菜单名称
     */
    public void setName(String name) {
            this.name = name;
    }
    /**
     * 获取：菜单名称
     */
    public String getName() {
            return name;
    }
    /**
     * 设置：菜单图标
     */
    public void setIcon(String icon) {
            this.icon = icon;
    }
    /**
     * 获取：菜单图标
     */
    public String getIcon() {
            return icon;
    }
    /**
     * 设置：请求地址
     */
    public void setUrl(String url) {
            this.url = url;
    }
    /**
     * 获取：请求地址
     */
    public String getUrl() {
            return url;
    }
    /**
     * 设置：菜单层级
     */
    public void setLevel(Long level) {
            this.level = level;
    }
    /**
     * 获取：菜单层级
     */
    public Long getLevel() {
            return level;
    }
    /**
     * 设置：菜单类型0菜单1按钮2后台api权限
     */
    public void setType(Long type) {
            this.type = type;
    }
    /**
     * 获取：菜单类型0菜单1按钮2后台api权限
     */
    public Long getType() {
            return type;
    }
    /**
     * 设置：菜单编号
     */
    public void setCode(String code) {
            this.code = code;
    }
    /**
     * 获取：菜单编号
     */
    public String getCode() {
            return code;
    }
    /**
     * 设置：父级菜单编号
     */
    public void setPcode(String pcode) {
            this.pcode = pcode;
    }
    /**
     * 获取：父级菜单编号
     */
    public String getPcode() {
            return pcode;
    }
    /**
     * 设置：排序字段
     */
    public void setSort(Long sort) {
            this.sort = sort;
    }
    /**
     * 获取：排序字段
     */
    public Long getSort() {
            return sort;
    }
    /**
     * 设置：菜单状态1启用0禁用
     */
    public void setStatus(Long status) {
            this.status = status;
    }
    /**
     * 获取：菜单状态1启用0禁用
     */
    public Long getStatus() {
            return status;
    }
    /**
     * 设置：提示信息

     */
    public void setTips(String tips) {
            this.tips = tips;
    }
    /**
     * 获取：提示信息

     */
    public String getTips() {
            return tips;
    }
}