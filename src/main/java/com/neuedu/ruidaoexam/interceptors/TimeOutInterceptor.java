package com.neuedu.ruidaoexam.interceptors;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * spring框架中还提供了一个技术,叫拦截器,实现方式要实现HandlerInterceptor接口,并重写3个方法
 * 
 * preHandle() : 进入某个之前要做的事
 * postHandle(): 执行完该方法后 ,但是还没渲染前页面时,要做的事(不常用)
 * afterCompletion(): 执行完该方法后 ,网页也渲染完毕 ,一次http请求完整的结束了之后,会执行该方法(不常用)
 * 
 * 拦截器主要作用 : 也能拦截http请求 , 拦截后 ,为进入的方法前后,加入日志,性能判断,事务处理
 * @author Administrator
 * 
 * 该拦截器实现 监控每个方法  执行的耗时时间
 * 
 * 
 * 拦截器需要配置到spring框架中  ,参考 config包 下的MyWebConfig.java文件
 *
 */
public class TimeOutInterceptor  implements HandlerInterceptor{
	
	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("ThreadLocal StartTime");

	//说明
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
			long beginTime = System.currentTimeMillis();
			startTimeThreadLocal.set(beginTime);
			System.out.printf("开始计时: {%s}  URI: {%s}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime),
					request.getRequestURI());
			System.out.println();
		
		return true;
	}
	
	//说明
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) {
	}
	
	//说明
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
			long beginTime = startTimeThreadLocal.get();
			long endTime = System.currentTimeMillis();
			System.out.printf("计时结束：{%s}  耗时：{%s}  URI: {%s}  ", new SimpleDateFormat("hh:mm:ss.SSS").format(endTime),
					((endTime - beginTime)/1000.0)+"秒",request.getRequestURI());
			System.out.println();
	}




}
