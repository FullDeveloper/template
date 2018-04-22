package com.template.cache.annotation;

import com.template.cache.constants.CacheScope;
import com.template.cache.parse.ICacheResultParser;
import com.template.cache.parse.IKeyGenerator;
import com.template.cache.parse.impl.DefaultKeyGenerator;
import com.template.cache.parse.impl.DefaultResultParser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 15:47
 * Description:
 */

@Retention(RetentionPolicy.RUNTIME)
// 在运行时可以获取
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// 作用到类，方法，接口上等
public @interface Cache {
    /**
     *  缓存key menu_{0.id}{1}_type
      * @return
     */
    String key() default "";

    /**
     * 作用域
     * @return
     */
    CacheScope scope() default CacheScope.application;

    /**
     * 过期时间
     * @return
     */
    int expire() default 720;

    /**
     * 描述信息
     * @return
     */
    String desc() default "";

    /**
     * 返回类型
     * @return
     */
    Class[] result() default Object.class;

    /**
     * 返回结果解析类
     * @return
     */
    Class<? extends ICacheResultParser> parser() default DefaultResultParser.class;

    /**
     * 键值解析类
     * @return
     */
    Class<? extends IKeyGenerator> generator() default DefaultKeyGenerator.class;

}
