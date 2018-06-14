package com.template.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/3/17 0017
 * Time: 20:32
 * Description:封装Java反射的API,对外提供更好用的工具方法.
 */
public class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     *
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     *
     * @param obj    目标对象
     * @param method 目标方法
     * @param args   方法参数
     * @return
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            LOGGER.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void setField(Object object, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(object, value);
        } catch (Exception e) {
            LOGGER.error("set field failure", e);
            throw new RuntimeException(e);
        }
    }

    public static String getFieldValueByName(Object object, String fieldName) throws IllegalAccessException {
        Object value = null;
        Field[] fields = object.getClass().getDeclaredFields();
        value = getObject(object, fieldName, value, fields);
        return String.valueOf(value);
    }

    private static Object getObject(Object object, String fieldName, Object value, Field[] fields) throws IllegalAccessException {
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            if (field.getName().equals(fieldName)) {
                value = field.get(object);
            }
        }
        return value;
    }

    public static Object getFieldObjectValueByName(Object object, String fieldName) throws IllegalAccessException {
        Object value = null;
        Field[] fields = object.getClass().getDeclaredFields();
        value = getObject(object, fieldName, value, fields);
        return value;
    }


}
