package com.template.provider.admin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 系统通知表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:53
 */
@Table(name = "sys_notice")
public class Notice implements Serializable{
private static final long serialVersionUID=1L;

        //
    @Id
    private Integer id;
    
        //通知标题
    @Column(name = "title")
    private String title;
    
        //通知类型

    @Column(name = "type")
    private Long type;
    
        //通知内容
    @Column(name = "content")
    private String content;
    
        //创建时间

    @Column(name = "create_time")
    private Date createTime;
    
        //创建人
    @Column(name = "create_user")
    private Long createUser;
    

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
     * 设置：通知标题
     */
    public void setTitle(String title) {
            this.title = title;
    }
    /**
     * 获取：通知标题
     */
    public String getTitle() {
            return title;
    }
    /**
     * 设置：通知类型

     */
    public void setType(Long type) {
            this.type = type;
    }
    /**
     * 获取：通知类型

     */
    public Long getType() {
            return type;
    }
    /**
     * 设置：通知内容
     */
    public void setContent(String content) {
            this.content = content;
    }
    /**
     * 获取：通知内容
     */
    public String getContent() {
            return content;
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
}