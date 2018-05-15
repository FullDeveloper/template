package com.template.common.bean;

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

    //日志名称
    private String logName;

    //日志类型
    private Long logType;

    //请求api的名称
    private String apiName;

    //请求参数
    private String params;

    //返回结果
    private String result;

    //请求方式
    private String method;

    //成功状态
    private Long successStatus;

    //创建时间
    private Date createTime;

    //创建人
    private Long createUser;

    //备注
    private String message;

    public LogInfo(String logName, Long logType, String apiName, String params, String result, String method, Long successStatus, Date createTime, Long createUser, String message) {
        this.logName = logName;
        this.logType = logType;
        this.apiName = apiName;
        this.params = params;
        this.result = result;
        this.method = method;
        this.successStatus = successStatus;
        this.createTime = createTime;
        this.createUser = createUser;
        this.message = message;
    }
}
