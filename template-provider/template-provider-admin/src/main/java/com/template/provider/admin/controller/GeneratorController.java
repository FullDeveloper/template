package com.template.provider.admin.controller;

import com.template.common.annotation.ParseParam;
import com.template.common.bean.Param;
import com.template.common.result.TableResultResponse;
import com.template.common.util.Query;
import com.template.provider.admin.biz.GeneratorBiz;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/5/5
 * TIME: 下午3:22
 * description:
 */
@RestController
@RequestMapping(value = "/generator")
public class GeneratorController {

    @Autowired
    private GeneratorBiz generatorBiz;

    @RequestMapping(value = "/page")
    public TableResultResponse getTableList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        return generatorBiz.queryList(query);
    }

    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public void generatorCode(@ParseParam Param param, HttpServletResponse response) throws IOException {

        byte[] data = generatorBiz.generatorCode(param);

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\""+param.getString("retName")+".zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());

    }

}
