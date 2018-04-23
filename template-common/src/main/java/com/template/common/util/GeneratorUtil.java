package com.template.common.util;

import java.util.UUID;

/**
 * Create By Project template
 *
 * @author zrb
 * @date 2018/4/23
 * description
 */
public class GeneratorUtil {

    public static String generatorUid(){
        return UUID.randomUUID().toString();
    }

}
