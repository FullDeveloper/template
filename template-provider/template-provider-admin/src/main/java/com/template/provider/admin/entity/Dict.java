package com.template.provider.admin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 系统字典表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:57
 */
@Table(name = "sys_dict")
public class Dict implements Serializable{
private static final long serialVersionUID=1L;

        //
    @Id
    private Integer id;
    
        //字典名称
    @Column(name = "name")
    private String name;
    
        //提示信息
    @Column(name = "tips")
    private String tips;
    
        //父级编号
    @Column(name = "pid")
    private Long pid;
    
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
     * 设置：字典名称
     */
    public void setName(String name) {
            this.name = name;
    }
    /**
     * 获取：字典名称
     */
    public String getName() {
            return name;
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
    /**
     * 设置：父级编号
     */
    public void setPid(Long pid) {
            this.pid = pid;
    }
    /**
     * 获取：父级编号
     */
    public Long getPid() {
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