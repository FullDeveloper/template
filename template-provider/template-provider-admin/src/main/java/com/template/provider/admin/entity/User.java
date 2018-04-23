package com.template.provider.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 系统用户表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:49
 */
@Table(name = "sys_user")
public class User implements Serializable{
private static final long serialVersionUID=1L;

        //
    @Id
    private Integer id;
    
        //系统交易编号
    @Column(name = "uid")
    private String uid;
    
        //用户名
    @Column(name = "username")
    @NotNull(message = "用户名不能为空")
    private String username;
    
        //密码
    @Column(name = "password")
    @NotNull(message = "密码不能为空")
    @Size(min=6, max=20, message = "密码长度必须在6和20之间")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
        //密码盐
    @Column(name = "salt")
    private String salt;
    
        //名称
    @Column(name = "name")
    private String name;
    
        //性别
    @Column(name = "sex")
    private Long sex;
    
        //邮件
    @Column(name = "email")
    private String email;
    
        //手机号
    @Column(name = "phone")
    private String phone;
    
        //生日
    @Column(name = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    
        //创建时间
    @Column(name = "create_time")
    private Date createTime;
    
        //创建目标主机地址
    @Column(name = "create_host")
    private String createHost;
    
        //账号状态0未审核通过1启用2禁用3已删除
    @Column(name = "status")
    private Long status;
    
        //用户头像
    @Column(name = "photo")
    private String photo;
    

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
     * 设置：系统交易编号
     */
    public void setUid(String uid) {
            this.uid = uid;
    }
    /**
     * 获取：系统交易编号
     */
    public String getUid() {
            return uid;
    }
    /**
     * 设置：用户名
     */
    public void setUsername(String username) {
            this.username = username;
    }
    /**
     * 获取：用户名
     */
    public String getUsername() {
            return username;
    }
    /**
     * 设置：密码
     */
    public void setPassword(String password) {
            this.password = password;
    }
    /**
     * 获取：密码
     */
    public String getPassword() {
            return password;
    }
    /**
     * 设置：密码盐
     */
    public void setSalt(String salt) {
            this.salt = salt;
    }
    /**
     * 获取：密码盐
     */
    public String getSalt() {
            return salt;
    }
    /**
     * 设置：名称
     */
    public void setName(String name) {
            this.name = name;
    }
    /**
     * 获取：名称
     */
    public String getName() {
            return name;
    }
    /**
     * 设置：性别
     */
    public void setSex(Long sex) {
            this.sex = sex;
    }
    /**
     * 获取：性别
     */
    public Long getSex() {
            return sex;
    }
    /**
     * 设置：邮件

     */
    public void setEmail(String email) {
            this.email = email;
    }
    /**
     * 获取：邮件

     */
    public String getEmail() {
            return email;
    }
    /**
     * 设置：手机号
     */
    public void setPhone(String phone) {
            this.phone = phone;
    }
    /**
     * 获取：手机号
     */
    public String getPhone() {
            return phone;
    }
    /**
     * 设置：生日
     */
    public void setBirthday(Date birthday) {
            this.birthday = birthday;
    }
    /**
     * 获取：生日
     */
    public Date getBirthday() {
            return birthday;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
            this.createTime = createTime;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
            return createTime;
    }
    /**
     * 设置：创建目标主机地址
     */
    public void setCreateHost(String createHost) {
            this.createHost = createHost;
    }
    /**
     * 获取：创建目标主机地址
     */
    public String getCreateHost() {
            return createHost;
    }
    /**
     * 设置：账号状态0未审核通过1启用2禁用3已删除
     */
    public void setStatus(Long status) {
            this.status = status;
    }
    /**
     * 获取：账号状态0未审核通过1启用2禁用3已删除
     */
    public Long getStatus() {
            return status;
    }
    /**
     * 设置：用户头像
     */
    public void setPhoto(String photo) {
            this.photo = photo;
    }
    /**
     * 获取：用户头像
     */
    public String getPhoto() {
            return photo;
    }
}