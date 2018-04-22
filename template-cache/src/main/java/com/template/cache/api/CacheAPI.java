package com.template.cache.api;

import com.template.cache.bean.CacheBean;

import java.util.List;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 16:51
 * Description: 缓存API
 */
public interface CacheAPI {
    /**
     * 传入key获取缓存json，需要用fastjson转换为对象
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 保存缓存
     * @param key 缓存key
     * @param value 缓存value
     * @param expireMin 过期时间 单位/分钟
     */
    void set(String key, Object value, int expireMin);

    /**
     * 保存缓存
     * @param key 缓存key
     * @param value 缓存value
     * @param expireMin 过期时间 单位/分钟
     * @param desc  描述信息
     */
    void set(String key, Object value, int expireMin, String desc);

    /**
     * 移除单个缓存
     * @param key
     * @return
     */
    Long remove(String key);

    /**
     * 移除多个缓存
     * @param keys
     * @return
     */
    Long remove(String... keys);

    /**
     * 按前缀移除缓存
     * @param pre
     * @return
     */
    Long removeByPre(String pre);

    /**
     * 通过前缀获取缓存信息
     * @param pre
     * @return
     */
    List<CacheBean> getCacheBeanByPre(String pre);

    /**
     * 获取所有缓存对象信息
     * @return
     */
    List<CacheBean> listAll();

    /**
     * 是否启用缓存
     * @return
     */
    boolean isEnabled();

    /**
     * 加入系统标志缓存
     * @param key
     * @return
     */
    String addSys(String key);

}
