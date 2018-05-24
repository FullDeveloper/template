package com.template.common.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/5/16
 * TIME: 上午12:25
 * description:
 */
@Data
public class LogInfo {

    private String logName;

    //日志类型
    private Long logType;

    //请求api的名称
    private String apiUrl;

    //请求参数
    private String params;

    //返回结果
    private String result;

    //请求方式
    private String method;

    //响应码
    private Long responseCode;

    //备注
    private String message;

    //请求开始时间
    private Long startTime;

    //请求结束时间
    private Long endTime;

    //请求耗时
    private Long milliseconds;

    //操作人
    private String optionId;

    public LogInfo(){}

    public LogInfo(String logName, Long logType, String apiUrl, String params, String result, String method, Long responseCode, String message, Long startTime, Long endTime, Long milliseconds, String optionId) {
        this.logName = logName;
        this.logType = logType;
        this.apiUrl = apiUrl;
        this.params = params;
        this.result = result;
        this.method = method;
        this.responseCode = responseCode;
        this.message = message;
        this.startTime = startTime;
        this.endTime = endTime;
        this.milliseconds = milliseconds;
        this.optionId = optionId;
    }
}
