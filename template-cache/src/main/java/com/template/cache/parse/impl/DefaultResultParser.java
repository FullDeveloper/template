package com.template.cache.parse.impl;

import com.alibaba.fastjson.JSON;
import com.template.cache.parse.ICacheResultParser;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 15:58
 * Description:
 */
public class DefaultResultParser implements ICacheResultParser {
    @Override
    public Object parse(String value, Type returnType, Class<?>... origins) {
        Object result = null;
        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            Type rawType = parameterizedType.getRawType();
            if (((Class) rawType).isAssignableFrom(List.class)) {
                result = JSON.parseArray(value, (Class) parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (origins == null) {
            result = JSON.parseObject(value, (Class) returnType);
        } else {
            result = JSON.parseObject(value, origins[0]);
        }
        return result;
    }
}
