package com.template.common.bean;

/**
 * Author: zrb
 * Date: 2018/4/24
 * Time: 14:45
 * Description:
 */
public class WrapObj {

    private Object obj;

    /**
     * 是否只在当前集合中存在
     * 如果是true，表示在外部比较集合中也存在，那么为True的都是并集，为false是差集
     */
    private boolean inOutside = false;

    public WrapObj(){}

    public WrapObj(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public boolean isInOutside() {
        return inOutside;
    }

    public void setInOutside(boolean inOutside) {
        this.inOutside = inOutside;
    }
}
