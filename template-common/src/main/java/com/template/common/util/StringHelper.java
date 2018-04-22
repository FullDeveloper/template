package com.template.common.util;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/4/5 0005
 * Time: 3:07
 * Description:
 */
public class StringHelper {

    public static String getObjectValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }


}
