package com.template.provider.admin.mapper;

import java.util.List;
import java.util.Map;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/5/5
 * TIME: 下午3:23
 * description:
 */
public interface GeneratorMapper {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

}
