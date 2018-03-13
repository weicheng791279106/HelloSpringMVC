package com.weicheng.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * ȫ���쳣������
 * 
 * */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	/**
	 * �������
	 * �Զ���Ĵ���ͷ��ش���ԭ��ҵ����󣩣����򷵻�"δ֪����"������ʱ����
	 * */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
		String message = "δ֪����";
		if(ex != null && ex instanceof CustomException) message = ex.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
