package com.template.provider.admin.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.template.common.bean.Param;
import com.template.common.result.TableResultResponse;
import com.template.common.util.Query;
import com.template.provider.admin.mapper.GeneratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
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

    public byte[] generatorCode(Param param) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        String tableName = param.getString("tableName");


        return null;
    }
}
