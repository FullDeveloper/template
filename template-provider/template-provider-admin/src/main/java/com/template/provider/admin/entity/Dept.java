package com.template.provider.admin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 系统部门表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:57
 */
@Table(name = "sys_dept")
public class Dept implements Serializable{
private static final long serialVersionUID=1L;

        //
    @Id
    private Integer id;
    
        //部门简称
    @Column(name = "simple_name")
    private String simpleName;
    
        //部门全称
    @Column(name = "full_name")
    private String fullName;
    
        //部门提示
    @Column(name = "tips")
    private String tips;
    
        //版本信息
    @Column(name = "version")
    private String version;
    
        //父级编号
    @Column(name = "pid")
    private Integer pid;
    
        //排序字段
    @Column(name = "sort")
    private Long sort;
    

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
     * 设置：部门简称
     */
    public void setSimpleName(String simpleName) {
            this.simpleName = simpleName;
    }
    /**
     * 获取：部门简称
     */
    public String getSimpleName() {
            return simpleName;
    }
    /**
     * 设置：部门全称
     */
    public void setFullName(String fullName) {
            this.fullName = fullName;
    }
    /**
     * 获取：部门全称
     */
    public String getFullName() {
            return fullName;
    }
    /**
     * 设置：部门提示
     */
    public void setTips(String tips) {
            this.tips = tips;
    }
    /**
     * 获取：部门提示
     */
    public String getTips() {
            return tips;
    }
    /**
     * 设置：版本信息
     */
    public void setVersion(String version) {
            this.version = version;
    }
    /**
     * 获取：版本信息
     */
    public String getVersion() {
            return version;
    }
    /**
     * 设置：父级编号
     */
    public void setPid(Integer pid) {
            this.pid = pid;
    }
    /**
     * 获取：父级编号
     */
    public Integer getPid() {
            return pid;
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
}