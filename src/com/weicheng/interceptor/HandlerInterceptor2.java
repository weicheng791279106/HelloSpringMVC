package com.weicheng.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor{

	@Override
	/**
	 * 进入Handler方法之前执行
	 * 常用于身份认证，身份授权
	 * 
	 * @return true表示放行执行handler方法，false表示拦截不向下执行
	 * */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("HandlerInterceptor2:preHandle");
		return true;
	}

	@Override
	/**
	 * 进入Handler方法之后返回modelAndView之前执行
	 * 常用于公用数据的添加
	 * */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor2:postHandle");
	}

	@Override
	/**
	 * 执行Handler完成后执行此方法
	 * 常用于异常处理，日志输出
	 * */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("HandlerInterceptor2:afterCompletion");
	}
	
}
