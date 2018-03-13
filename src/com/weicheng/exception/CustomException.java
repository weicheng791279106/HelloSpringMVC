package com.weicheng.exception;

/**
 * 自定义异常类（业务异常）
 * */
public class CustomException extends Exception{
	
	private String message;

	public CustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
