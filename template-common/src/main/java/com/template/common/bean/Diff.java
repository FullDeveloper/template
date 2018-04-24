package com.template.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zrb
 * Date: 2018/4/24
 * Time: 14:21
 * Description:
 */
public class Diff {

    private String fieldName; //字段名称

    private Object oldValue; //老的值

    private Object newValue; //新的值

    private int type = 0; // 0:NONE 新旧有对应　;1:Delete　新的已经删除 2: Add 新的属于新增加

    private int level = 0; //0 实体，１，信息字段

    private int diff = 0 ; //0 相同，1　不相同，可以自动审批，　2 不相同，但是需要人工

    private List<Diff> subDiff = new ArrayList<>();

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public List<Diff> getSubDiff() {
        return subDiff;
    }

    public void setSubDiff(List<Diff> subDiff) {
        this.subDiff = subDiff;
    }
}
