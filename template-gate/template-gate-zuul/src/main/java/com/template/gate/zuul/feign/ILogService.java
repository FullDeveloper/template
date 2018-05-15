package com.template.gate.zuul.feign;

import com.template.common.bean.LogInfo;
import com.template.gate.zuul.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/5/16
 * TIME: 上午12:28
 * description:
 */
@FeignClient(value = "template-provider-admin")
public interface ILogService {

    @RequestMapping(value="/api/log/save",method = RequestMethod.POST)
    void saveLog(LogInfo log);
}
