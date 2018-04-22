package com.template.cache;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 17:13
 * Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfiguration.class)
@Documented
@Inherited
public @interface EnableCache {
}
