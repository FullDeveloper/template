package com.template.provider.admin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 系统操作日志
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:52
 */
@Table(name = "sys_operation_log")
public class OperationLog implements Serializable{
private static final long serialVersionUID=1L;

        //
    @Id
    private Integer id;
    
        //日志名称
    @Column(name = "log_name")
    private String logName;
    
        //日志类型
    @Column(name = "log_type")
    private Long logType;
    
        //请求api的名称
    @Column(name = "api_name")
    private String apiName;
    
        //请求参数
    @Column(name = "params")
    private String params;
    
        //返回结果
    @Column(name = "result")
    private String result;
    
        //请求方式
    @Column(name = "method")
    private String method;
    
        //成功状态
    @Column(name = "success_status")
    private Long successStatus;
    
        //创建时间
    @Column(name = "create_time")
    private Date createTime;
    
        //创建人
    @Column(name = "create_user")
    private Long createUser;
    
        //备注
    @Column(name = "message")
    private String message;
    

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
    public void setLogName(String logName) {
            this.logName = logName;
    }
    /**
     * 获取：日志名称
     */
    public String getLogName() {
            return logName;
    }
    /**
     * 设置：日志类型
     */
    public void setLogType(Long logType) {
            this.logType = logType;
    }
    /**
     * 获取：日志类型
     */
    public Long getLogType() {
            return logType;
    }
    /**
     * 设置：请求api的名称
     */
    public void setApiName(String apiName) {
            this.apiName = apiName;
    }
    /**
     * 获取：请求api的名称
     */
    public String getApiName() {
            return apiName;
    }
    /**
     * 设置：请求参数
     */
    public void setParams(String params) {
            this.params = params;
    }
    /**
     * 获取：请求参数
     */
    public String getParams() {
            return params;
    }
    /**
     * 设置：返回结果
     */
    public void setResult(String result) {
            this.result = result;
    }
    /**
     * 获取：返回结果
     */
    public String getResult() {
            return result;
    }
    /**
     * 设置：请求方式
     */
    public void setMethod(String method) {
            this.method = method;
    }
    /**
     * 获取：请求方式
     */
    public String getMethod() {
            return method;
    }
    /**
     * 设置：成功状态
     */
    public void setSuccessStatus(Long successStatus) {
            this.successStatus = successStatus;
    }
    /**
     * 获取：成功状态
     */
    public Long getSuccessStatus() {
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
    /**
     * 设置：创建人
     */
    public void setCreateUser(Long createUser) {
            this.createUser = createUser;
    }
    /**
     * 获取：创建人
     */
    public Long getCreateUser() {
            return createUser;
    }
    /**
     * 设置：备注
     */
    public void setMessage(String message) {
            this.message = message;
    }
    /**
     * 获取：备注
     */
    public String getMessage() {
            return message;
    }
}