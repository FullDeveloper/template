package com.template.common.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zrb
 * Date: 2018/6/1
 * Time: 17:47
 * Description:
 * a: {1,2,3}. b: {3,4,5}
 * 并集： 称之为并集 1,2,3,4,5
 * 交集： 某个元素在A集合中又在B集合中称之为交集   交集为 3
 * 差集： A、B两个集合  A中集合的元素 不存在B中的集合 称之为差集    b与a的差集为 1,2
 */
public class ListUtils {


    // 变更门店或者卡种的时候。   如果集合A中的门店 和集合B中的门店  有交集。

    /**
     * 得到A中包含B的所有元素（交集） 一致不需要删除
     * 如果B[i] = A[i] 那么 B[i] 是A集合的交集
     *
     * @param A
     * @param B
     * @param fields
     * @param <T>
     * @return
     */
    public static <T, S> List<String[]> getTwoListRetainAll(List<T> A, List<S> B, String[] fields) throws IllegalAccessException {
        List<String[]> clazz = new ArrayList<>();
        for (T t : A) {
            for (S t2 : B) {
                boolean pass = false;
                String[] values = new String[fields.length];
                boolean flag = false;
                for (int i = 0; i < fields.length; i++) {
                    Object v1 = ReflectionUtil.getFieldObjectValueByName(t, fields[i]);
                    Object v2 = ReflectionUtil.getFieldObjectValueByName(t2, fields[i]);
                    if (!v1.equals(v2)) {
                        flag = true;
                    }
                    values[i] = v2 + "";
                }
                if(!flag){
                    pass = true;
                }
                if (pass) {
                    clazz.add(values);
                }
            }
        }
        return clazz;
    }

    /**
     * 得到B中不包含A的所有元素（差集） 进行删除操作
     *
     * @param A
     * @param B
     * @param fields
     * @param <T>
     * @return
     */
    public static <T, S> List<String[]> getTwoListRemoveAll(List<T> A, List<S> B, String[] fields) throws IllegalAccessException {
        List<String[]> clazz = new ArrayList<>();
        for (T t : A) {
            boolean pass = false;
            String[] values = null;
            for (S t2 : B) {
                values = new String[fields.length];
                boolean flag = false;
                for (int i = 0; i < fields.length; i++) {
                    Object v1 = ReflectionUtil.getFieldObjectValueByName(t, fields[i]);
                    Object v2 = ReflectionUtil.getFieldObjectValueByName(t2, fields[i]);
                    // 只要有一个不等于就是true
                    if(!v1.equals(v2)){
                        flag = true;
                    }
                    /*if (v1.equals(v2)) {
                        pass = true;
                    }else{
                        pass = false;
                    }*/
                    values[i] = v1 + "";
                }

                // 两个值相等
                if(!flag){
                    pass = true;
                }

            }
            if (!pass) {
                clazz.add(values);
            }

        }
        return clazz;
    }

}
