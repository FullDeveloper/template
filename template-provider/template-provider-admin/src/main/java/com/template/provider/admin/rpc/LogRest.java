package com.template.provider.admin.rpc;

import com.template.common.bean.LogInfo;
import com.template.provider.admin.biz.OperationLogBiz;
import com.template.provider.admin.entity.OperationLog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-07-01 14:39
 */
@RequestMapping("api")
@RestController
public class LogRest {

    @Autowired
    private OperationLogBiz operationLogBiz;

    @RequestMapping(value="/log/save",method = RequestMethod.POST)
    public @ResponseBody void saveLog(@RequestBody LogInfo info){
        OperationLog log = new OperationLog();
        BeanUtils.copyProperties(info,log);
        operationLogBiz.insertSelective(log);
    }
}
