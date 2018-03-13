package com.weicheng.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ������ʹ��ʾ��
 * 
 * ����������������ʱ�ĵ���˳��
 * 	HandlerInterceptor1:preHandle
	HandlerInterceptor2:preHandle
	HandlerInterceptor2:postHandle
	HandlerInterceptor1:postHandle
	HandlerInterceptor2:afterCompletion
	HandlerInterceptor1:afterCompletion
	
	
 * HandlerInterceptor1����HandlerInterceptor2�����У�
 * 	HandlerInterceptor1:preHandle
	HandlerInterceptor2:preHandle
	HandlerInterceptor1:afterCompletion
 * 
 * 
 * HandlerInterceptor1������HandlerInterceptor2�����У�
 * 	HandlerInterceptor1:preHandle
 * 
 * */
public class HandlerInterceptor1 implements HandlerInterceptor{

	@Override
	/**
	 * ����Handler����֮ǰִ��
	 * ������������֤��������Ȩ
	 * 
	 * @return true��ʾ����ִ��handler������false��ʾ���ز�����ִ��
	 * */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("HandlerInterceptor1:preHandle");
		return true;
	}

	@Override
	/**
	 * ����Handler����֮�󷵻�modelAndView֮ǰִ��
	 * �����ڹ������ݵ�����
	 * */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor1:postHandle");
	}

	@Override
	/**
	 * ִ��Handler��ɺ�ִ�д˷���
	 * �������쳣��������־���
	 * */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("HandlerInterceptor1:afterCompletion");
	}

}