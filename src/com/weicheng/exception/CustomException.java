package com.weicheng.exception;

/**
 * �Զ����쳣�ࣨҵ���쳣��
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
