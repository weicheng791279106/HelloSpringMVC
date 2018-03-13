package com.weicheng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.weicheng.po.Item;

/**ʵ��HttpRequestHandler�ӿڵ�Handler��ʾ�����HttpRequestHandlerAdapterʹ�ã�������json����*/
public class ItemController3 implements HttpRequestHandler{

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
		
		/*ʹ�ô˷�ʽʵ��Handler����ͨ���޸�response��������Ҫ��Ӧ�����ݸ�ʽ��������Ӧjson����*/
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("{\"code\":100,\"data\":[],\"message\":\"��ȡ���ݳɹ�\"}");
		
	}
	
}
