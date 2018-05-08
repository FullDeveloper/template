package com.template.provider.admin.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.template.common.bean.Param;
import com.template.common.result.TableResultResponse;
import com.template.common.util.Query;
import com.template.provider.admin.mapper.GeneratorMapper;
import com.template.provider.admin.util.GeneratorUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/5/5
 * TIME: 下午3:24
 * description:
 */
@Service
public class GeneratorBiz {

    @Autowired
    private GeneratorMapper generatorMapper;

    public TableResultResponse queryList(Query query) {
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Map<String,Object>> list = generatorMapper.queryList(query);
        return new TableResultResponse<>(result.getTotal(), list);
    }

    public Map<String, String> queryTable(String tableName) {
        return generatorMapper.queryTable(tableName);
    }

    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorMapper.queryColumns(tableName);
    }


    public byte[] generatorCode(Map<String, Object> param) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        List<String> tableNames = (ArrayList<String>) param.get("tableName");
        for(String tableName: tableNames){
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);

            GeneratorUtils.generatorCode(param, table, columns, zip);

        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
