package com.template.cache.parse;

import java.lang.reflect.Type;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 15:58
 * Description:
 */
public interface ICacheResultParser {

    /**
     * 解析结果
     *
     * @param value
     * @param returnType
     * @param origins
     * @return
     */
    Object parse(String value, Type returnType, Class<?>... origins);

}
