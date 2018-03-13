package com.weicheng.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weicheng.exception.CustomException;

/**用户认证模块Controller*/
@Controller
@RequestMapping("user/")
public class LoginController {
	
	/**登录*/
	@RequestMapping("login")
	public String login(HttpSession httpSession,String userName,String pwd) throws Exception {
		if(userName != null && userName.equals("weixiaobao") && pwd != null && pwd.equals("123456")) httpSession.setAttribute("userName", userName); /*在session中保存用户信息*/
		else throw new CustomException("用户名或密码错误");
		return "redirect:/items/queryItems.action";
	}
	
	/**退出登录*/
	@RequestMapping("logout")
	public String logout(HttpSession httpSession) throws Exception {
		httpSession.invalidate();
		return "login";
	}

}
