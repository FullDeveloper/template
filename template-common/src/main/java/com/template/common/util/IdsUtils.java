package com.template.common.util;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Author: zrb
 * Date: 2018/5/4
 * Time: 10:46
 * Description:
 */
public class IdsUtils {


    public static String assembleListToIds(List list, String fieldName) throws IllegalAccessException {
        StringBuilder ids = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String id = ReflectionUtil.getFieldValueByName(list.get(i), fieldName);
                if (i > 0) {
                    ids.append(",");
                }
                ids.append("'").append(id).append("'");
            }
        }
        return ids.toString();
    }

    public static String assembleListToStr(List list, String fieldName) throws IllegalAccessException {
        StringBuilder ids = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String id = ReflectionUtil.getFieldValueByName(list.get(i), fieldName);
                if (i > 0) {
                    ids.append(",");
                }
                ids.append(id);
            }
        }
        return ids.toString();
    }

    public static String splitStrToIds(String ids, String regex) {
        StringBuilder sb = new StringBuilder();
        String[] idArray = ids.split(regex);
        for (int i = 0; i < idArray.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("'").append(idArray[i]).append("'");
        }
        return sb.toString();
    }


}
