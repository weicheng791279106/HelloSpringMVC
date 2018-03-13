package com.weicheng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.weicheng.po.Item;

/**实现HttpRequestHandler接口的Handler演示（配合HttpRequestHandlerAdapter使用），返回一个jsp视图*/
public class ItemController2 implements HttpRequestHandler{

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
		
		/*返回一个jsp视图*/
		/*设置设置模型属性，在jsp页面中将属性读取出来显示，所以这里的属性名称要与jsp页面中的属性名称对应*/
		request.setAttribute("itemsList", itemList);
		/*设置转发的视图*/
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
		
	}

}
