package com.weicheng.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * 
 * */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	/**
	 * 处理错误
	 * 自定义的错误就返回错误原因（业务错误），否则返回"未知错误"（运行时错误）
	 * */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
		String message = "未知错误";
		if(ex != null && ex instanceof CustomException) message = ex.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
