package com.template.provider.admin.config;

import com.template.auth.client.interceptor.ServiceAuthInterceptor;
import com.template.auth.client.interceptor.UserAuthInterceptor;
import com.template.common.handler.GlobalExceptionHandler;
import com.template.common.resolver.FileFieldParamResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create By Project Pcc_Microservice
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

        // 注册FileFieldParamResolver的参数分解器
        argumentResolvers.add(new FileFieldParamResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getServiceAuthRestInterceptor()).
                addPathPatterns(getIncludePathPatterns())
                .excludePathPatterns("/api/log/save").addPathPatterns("/api/user/validate");

        registry.addInterceptor(getUserAuthRestInterceptor()).
                addPathPatterns(getIncludePathPatterns())
                .excludePathPatterns("/generator/code")
                .excludePathPatterns("/api/log/save")
                .excludePathPatterns("/api/user/validate");
    }

    @Bean
    ServiceAuthInterceptor getServiceAuthRestInterceptor() {
        return new ServiceAuthInterceptor();
    }

    @Bean
    UserAuthInterceptor getUserAuthRestInterceptor() {
        return new UserAuthInterceptor();
    }

    /**
     * 需要用户和服务认证判断的路径
     *
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

}
