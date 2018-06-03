package com.template.common.bean;

import java.util.List;

/**
 * Author: zrb
 * Date: 2018/5/31
 * Time: 10:41
 * Description:
 */
public class RouteItem {

    private boolean hidden; //是否隐藏

    private String path; //跳转路径

    private String name;

    private Meta meta;

    private List<RouteItem> children;


    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<RouteItem> getChildren() {
        return children;
    }

    public void setChildren(List<RouteItem> children) {
        this.children = children;
    }
}
