package com.template.gate.zuul.aspect;

import com.template.common.bean.LogInfo;
import com.template.common.constant.CommonConstants;
import com.template.common.context.BaseContextHandler;
import com.template.gate.zuul.util.DBLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/5/17
 * TIME: 上午12:11
 * description:
 */
@Component
@Aspect
@Slf4j
@Order(6)
public class GateLogAspect {

    /**
     * 定义一个切入点.
     * <p>
     * 解释下：
     * <p>
     * <p>
     * <p>
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * <p>
     * ~ 第二个 * 任意包名
     * <p>
     * ~ 第三个 * 代表任意方法.
     * <p>
     * ~ 第四个 * 定义在web包或者子包
     * <p>
     * ~ 第五个 * 任意方法
     * <p>
     * ~ .. 匹配任意数量的参数.
     * public * com.kfit.*.web..*.*(..))"
     */

    @Pointcut("execution(public * com.template.gate.zuul.filter.ClientAccessFilter.*(..))")
    public void gateRequestAspect() {
    }

    @Pointcut("execution(public * com.template.auth.client.interceptor.OkHttpTokenInterceptor.*(..))")
    public void gateResponseAspect() {
    }

    // @Before("gateResponseAspect() || gateRequestAspect()")
    @Before("gateResponseAspect()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        log.info("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();

            // 记录下请求内容
            BaseContextHandler.get("logInfo");
            log.info("URL : " + request.getRequestURL().toString());
            log.info("HTTP_METHOD : " + request.getMethod());
            log.info("IP : " + request.getRemoteAddr());
            log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

            //获取所有参数方法一：

            Enumeration<String> enu = request.getParameterNames();

            while (enu.hasMoreElements()) {
                String paraName = (String) enu.nextElement();
                System.out.println(paraName + ": " + request.getParameter(paraName));
            }
        }


    }


    // @AfterReturning("gateResponseAspect() || gateRequestAspect()")
    @AfterReturning("gateResponseAspect()")
    public void doAfterReturning(JoinPoint joinPoint) {

        // 处理完请求，返回内容
        log.info("WebLogAspect.doAfterReturning()");

        Object object = BaseContextHandler.get(CommonConstants.LOG_INFO_NAME);
        if(object != null){
            LogInfo logInfo = (LogInfo) object;
            logInfo.setEndTime(System.currentTimeMillis());
            logInfo.setMilliseconds(logInfo.getEndTime() - logInfo.getStartTime());
            DBLog.getInstance().offerQueue(logInfo);
            log.info("将记录日志操作丢入队列中进行处理！");
            BaseContextHandler.remove(CommonConstants.LOG_INFO_NAME);
        }

    }

}
