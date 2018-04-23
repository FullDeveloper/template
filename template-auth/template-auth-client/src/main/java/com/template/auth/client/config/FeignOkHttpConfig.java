package com.template.auth.client.config;

import com.template.auth.client.interceptor.OkHttpTokenInterceptor;
import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
@ConditionalOnClass(Feign.class)
@Slf4j
public class FeignOkHttpConfig {

	@Autowired
	OkHttpTokenInterceptor okHttpLoggingInterceptor;

	private int feignOkHttpReadTimeout = 60;
	private int feignConnectTimeout = 60;
	private int feignWriteTimeout = 120;

	@Bean
	public okhttp3.OkHttpClient okHttpClient() {
		log.info("okttp3 替代 httpclient.........");
		return new okhttp3.OkHttpClient.Builder()
					.readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
					.connectTimeout(feignConnectTimeout, TimeUnit.SECONDS)
					.writeTimeout(feignWriteTimeout, TimeUnit.SECONDS).connectionPool(new ConnectionPool())
				 	.addInterceptor(okHttpLoggingInterceptor)
				.build();
	}
}
