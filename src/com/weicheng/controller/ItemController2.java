package com.weicheng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.weicheng.po.Item;

/**ʵ��HttpRequestHandler�ӿڵ�Handler��ʾ�����HttpRequestHandlerAdapterʹ�ã�������һ��jsp��ͼ*/
public class ItemController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> itemList = new ArrayList<>();
		
		Item item1 = new Item();
		item1.setName("����ʼǱ�");
		item1.setDetail("����ʼǱ���������ʼǱ�");
		itemList.add(item1);
		
		Item item2 = new Item();
		item2.setName("ƻ���ֻ�");
		item2.setDetail("ƻ���ֻ�����ƻ���ֻ�");
		itemList.add(item2);
		
		/*����һ��jsp��ͼ*/
		/*��������ģ�����ԣ���jspҳ���н����Զ�ȡ������ʾ�������������������Ҫ��jspҳ���е��������ƶ�Ӧ*/
		request.setAttribute("itemsList", itemList);
		/*����ת������ͼ*/
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
		
	}

}
