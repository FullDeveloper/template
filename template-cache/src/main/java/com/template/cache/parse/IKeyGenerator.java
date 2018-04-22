package com.template.cache.parse;

import com.template.cache.constants.CacheScope;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 15:49
 * Description: 缓存键值表达式
 */
public abstract class IKeyGenerator {

    public static final String LINK = "_";

    /**
     * 获取动态key
     *
     * @param key
     * @param scope
     * @param parameterTypes
     * @param arguments
     * @return
     */
    public String getKey(String key, CacheScope scope, Class<?>[] parameterTypes, Object[] arguments) {
        StringBuffer sb = new StringBuffer("");
        key = buildKey(key, scope, parameterTypes, arguments);
        sb.append(key);
        if (CacheScope.user.equals(scope)) {
            if (getUserKeyGenerator() != null){
                sb.append(LINK)
                        .append(getUserKeyGenerator().getCurrentUserAccount());
            }

        }
        return sb.toString();
    }

    public abstract IUserKeyGenerator getUserKeyGenerator();

    public abstract String buildKey(String key, CacheScope scope, Class<?>[] parameterTypes, Object[] arguments);

}
