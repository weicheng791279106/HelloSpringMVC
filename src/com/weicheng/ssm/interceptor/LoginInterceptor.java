package com.weicheng.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录校验拦截器
 * 需要到springmvc.xml文件中配置
 * */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		if(request.getRequestURI().contains("login")) return true; /*登录接口不拦截*/
		if(request.getSession().getAttribute("userName") != null) return true; /*不是登录接口，通过session中保存的用户信息判断是否已登录*/
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response); /*未登录，跳转到登录页面*/
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		
	}

}
