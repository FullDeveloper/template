package com.template.provider.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 系统操作日志
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-05-24 21:01:24
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
    @Column(name = "api_url")
    private String apiUrl;
    
        //请求参数
    @Column(name = "params")
    private String params;
    
        //返回结果
    @Column(name = "result")
    private String result;
    
        //请求方式
    @Column(name = "method")
    private String method;
    
        //响应码
    @Column(name = "response_code")
    private Long responseCode;
    
        //备注
    @Column(name = "message")
    private String message;
    
        //请求开始时间
    @Column(name = "start_time")
    private Long startTime;
    
        //请求结束时间
    @Column(name = "end_time")
    private Long endTime;
    
        //请求耗时
    @Column(name = "milliseconds")
    private Long milliseconds;
    
        //操作人
    @Column(name = "option_id")
    private String optionId;
    

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
    public void setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
    }
    /**
     * 获取：请求api的名称
     */
    public String getApiUrl() {
            return apiUrl;
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
     * 设置：响应码
     */
    public void setResponseCode(Long responseCode) {
            this.responseCode = responseCode;
    }
    /**
     * 获取：响应码
     */
    public Long getResponseCode() {
            return responseCode;
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
    /**
     * 设置：请求开始时间
     */
    public void setStartTime(Long startTime) {
            this.startTime = startTime;
    }
    /**
     * 获取：请求开始时间
     */
    public Long getStartTime() {
            return startTime;
    }
    /**
     * 设置：请求结束时间
     */
    public void setEndTime(Long endTime) {
            this.endTime = endTime;
    }
    /**
     * 获取：请求结束时间
     */
    public Long getEndTime() {
            return endTime;
    }
    /**
     * 设置：请求耗时
     */
    public void setMilliseconds(Long milliseconds) {
            this.milliseconds = milliseconds;
    }
    /**
     * 获取：请求耗时
     */
    public Long getMilliseconds() {
            return milliseconds;
    }
    /**
     * 设置：操作人
     */
    public void setOptionId(String optionId) {
            this.optionId = optionId;
    }
    /**
     * 获取：操作人
     */
    public String getOptionId() {
            return optionId;
    }
}