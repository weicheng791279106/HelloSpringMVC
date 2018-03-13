package com.weicheng.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weicheng.exception.CustomException;

/**�û���֤ģ��Controller*/
@Controller
@RequestMapping("user/")
public class LoginController {
	
	/**��¼*/
	@RequestMapping("login")
	public String login(HttpSession httpSession,String userName,String pwd) throws Exception {
		if(userName != null && userName.equals("weixiaobao") && pwd != null && pwd.equals("123456")) httpSession.setAttribute("userName", userName); /*��session�б����û���Ϣ*/
		else throw new CustomException("�û������������");
		return "redirect:/items/queryItems.action";
	}
	
	/**�˳���¼*/
	@RequestMapping("logout")
	public String logout(HttpSession httpSession) throws Exception {
		httpSession.invalidate();
		return "login";
	}

}
