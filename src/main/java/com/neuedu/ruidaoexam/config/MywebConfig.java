package com.neuedu.ruidaoexam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.neuedu.ruidaoexam.interceptors.TimeOutInterceptor;
/**
 * @Configuration 表示该类是一个配置文件类
 * @author Administrator
 * 
 * 实现 WebMvcConfigurer 接口  ,并重写addInterceptors 该方法,表示将拦截器注册到spring框架中
 */
@Configuration
public class MywebConfig implements WebMvcConfigurer {
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new TimeOutInterceptor()) 
	                .addPathPatterns("/**"); 
	    }
}
