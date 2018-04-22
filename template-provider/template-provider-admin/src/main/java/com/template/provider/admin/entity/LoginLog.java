package com.template.provider.admin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 系统登录日志表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:56
 */
@Table(name = "sys_login_log")
public class LoginLog implements Serializable{
private static final long serialVersionUID=1L;

        //
    @Id
    private Integer id;
    
        //日志名称
    @Column(name = "login_name")
    private String loginName;
    
        //用户编号
    @Column(name = "user_id")
    private Long userId;
    
        //具体信息
    @Column(name = "message")
    private String message;
    
        //请求IP地址
    @Column(name = "ip")
    private String ip;
    
        //是否执行成功
    @Column(name = "success_status")
    private String successStatus;
    
        //创建时间
    @Column(name = "create_time")
    private Date createTime;
    

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
     * 设置：日志名称
     */
    public void setLoginName(String loginName) {
            this.loginName = loginName;
    }
    /**
     * 获取：日志名称
     */
    public String getLoginName() {
            return loginName;
    }
    /**
     * 设置：用户编号
     */
    public void setUserId(Long userId) {
            this.userId = userId;
    }
    /**
     * 获取：用户编号
     */
    public Long getUserId() {
            return userId;
    }
    /**
     * 设置：具体信息
     */
    public void setMessage(String message) {
            this.message = message;
    }
    /**
     * 获取：具体信息
     */
    public String getMessage() {
            return message;
    }
    /**
     * 设置：请求IP地址
     */
    public void setIp(String ip) {
            this.ip = ip;
    }
    /**
     * 获取：请求IP地址
     */
    public String getIp() {
            return ip;
    }
    /**
     * 设置：是否执行成功
     */
    public void setSuccessStatus(String successStatus) {
            this.successStatus = successStatus;
    }
    /**
     * 获取：是否执行成功
     */
    public String getSuccessStatus() {
            return successStatus;
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
}