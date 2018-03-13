package com.weicheng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.weicheng.po.Item;

/**ʵ��Controller�ӿڵ�Handler��ʾ�����SimpleControllerHandlerAdapterʹ�ã�������һ��jsp��ͼ*/
public class ItemController1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Item> itemList = new ArrayList<>();
		
		Item item1 = new Item();
		item1.setName("����ʼǱ�");
		item1.setDetail("����ʼǱ���������ʼǱ�");
		itemList.add(item1);
		
		Item item2 = new Item();
		item2.setName("ƻ���ֻ�");
		item2.setDetail("ƻ���ֻ�����ƻ���ֻ�");
		itemList.add(item2);
		
		ModelAndView modelAndView = new ModelAndView();
		/*����modelAndView�����ԣ���jspҳ���н����Զ�ȡ������ʾ�������������������Ҫ��jspҳ���е��������ƶ�Ӧ*/
		modelAndView.addObject("itemsList",itemList);
		/*ָ����ͼ*/
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp"); //����View��ַ��ʾ
		modelAndView.setViewName("items/itemsList"); //�����������ļ�����������ͼ·����ǰ��׺���������ﲻ��д������ַ
		
		return modelAndView;
	}

}
