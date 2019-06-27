package com.neuedu.ruidaoexam.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;

/**
 * @Component 要在spring框架中,过滤器类上,加入@Component该注解 ,表示将该过滤器注册到水平框架中
 * 过滤器做的事  : 过滤http请求
 */
@Component
@WebFilter(filterName="filter1",urlPatterns="/*")
public class Filter1 implements Filter {

	//随着****Application.java文件启动 ,
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter init success");
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * 过滤每一次http请求
	 */
	public void doFilter(
			ServletRequest request,
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		chain.doFilter(request, response);
		return;
	}


}
