package com.template.cache.service;

import com.template.cache.bean.CacheBean;
import com.template.cache.bean.CacheTree;

import java.util.List;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 17:02
 * Description:
 */
public interface ICacheManager {

    void removeAll();

    void remove(String key);

    void remove(List<CacheBean> caches);

    void removeByPre(String pre);

    List<CacheTree> getAll();

    List<CacheTree> getByPre(String pre);

    void update(String key, int hour);

    void update(List<CacheBean> caches, int hour);

    String get(String key);

}
