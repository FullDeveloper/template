package com.template.provider.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.common.annotation.ParseParam;
import com.template.common.bean.Param;
import com.template.common.result.TableResultResponse;
import com.template.common.util.Query;
import com.template.provider.admin.biz.GeneratorBiz;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    @RequestMapping(value = "/code")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response, String requestJson) throws IOException {

       /* InputStream in = request.getInputStream();

        BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(in));
        StringBuffer tStringBuffer = new StringBuffer();
        String sTempOneLine = new String("");
        while ((sTempOneLine = tBufferedReader.readLine()) != null) {
            tStringBuffer.append(sTempOneLine);
        }
        System.out.println(tStringBuffer.toString());*/
        ObjectMapper mapper = new ObjectMapper();
        Map param = mapper.readValue(requestJson, Map.class);
        //Map param = mapper.readValue(tStringBuffer.toString(),Map.class);
        byte[] data = generatorBiz.generatorCode(param);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + param.get("zipName").toString() + ".zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());

    }

}
