package com.weicheng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.weicheng.po.Item;

/**实现Controller接口的Handler演示（配合SimpleControllerHandlerAdapter使用），返回一个jsp视图*/
public class ItemController1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Item> itemList = new ArrayList<>();
		
		Item item1 = new Item();
		item1.setName("联想笔记本");
		item1.setDetail("联想笔记本就是联想笔记本");
		itemList.add(item1);
		
		Item item2 = new Item();
		item2.setName("苹果手机");
		item2.setDetail("苹果手机就是苹果手机");
		itemList.add(item2);
		
		ModelAndView modelAndView = new ModelAndView();
		/*设置modelAndView的属性，在jsp页面中将属性读取出来显示，所以这里的属性名称要与jsp页面中的属性名称对应*/
		modelAndView.addObject("itemsList",itemList);
		/*指定视图*/
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp"); //完整View地址演示
		modelAndView.setViewName("items/itemsList"); //由于在配置文件中配置了视图路径的前后缀，所以这里不必写完整地址
		
		return modelAndView;
	}

}
