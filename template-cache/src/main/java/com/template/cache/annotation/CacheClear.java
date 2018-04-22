package com.template.cache.annotation;

import com.template.cache.parse.IKeyGenerator;
import com.template.cache.parse.impl.DefaultKeyGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 15:59
 * Description:
 */
@Retention(RetentionPolicy.RUNTIME)//在运行时可以获取
@Target(value = {ElementType.METHOD, ElementType.TYPE})//作用到类，方法，接口上等
public @interface CacheClear {
    /**
     * 缓存key的前缀
     * @return
     */
    String pre() default "";

    /**
     * 缓存key
     * @return
     */
    String key() default "";

    /**
     * 缓存keys
     * @return
     */
    String[] keys() default "";

    /**
     * 键值解析类
     * @return
     */
    Class<? extends IKeyGenerator> generator() default DefaultKeyGenerator.class;

}
