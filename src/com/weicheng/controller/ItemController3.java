package com.weicheng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.weicheng.po.Item;

/**实现HttpRequestHandler接口的Handler演示（配合HttpRequestHandlerAdapter使用），返回json数据*/
public class ItemController3 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> itemList = new ArrayList<>();
		
		Item item1 = new Item();
		item1.setName("联想笔记本");
		item1.setDetail("联想笔记本就是联想笔记本");
		itemList.add(item1);
		
		Item item2 = new Item();
		item2.setName("苹果手机");
		item2.setDetail("苹果手机就是苹果手机");
		itemList.add(item2);
		
		/*使用此方式实现Handler可以通过修改response来设置需要相应的数据格式，比如相应json数据*/
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("{\"code\":100,\"data\":[],\"message\":\"获取数据成功\"}");
		
	}
	
}
