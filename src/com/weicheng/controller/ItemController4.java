package com.weicheng.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.weicheng.exception.CustomException;
import com.weicheng.po.Item;
import com.weicheng.po.ItemVo;

/**
 * ע�ⷽʽʵ��Handler��ʾ {@link #queryItems4}
 * 
 * ҳ���ض���ҳ��ת����ʾ {@link #redirectTestApi} {@link #forwardTestApi}
 * 
 * ����json������ʾ {@link #returnJsonApi}
 * 
 * ���ݰ���ʾ���������������Ͱ���ʾ������@RequestParamע��������ݰ���ʾ {@link #simpleParamsApi} {@link #annoParamsApi}
 * 
 * ʹ��@RequestMappingע����������ʽ��ʾ {@link #requestMappingTestApi}
 * 
 * Pojo�����������ʾ����װ����pojo��������ʾ {@link #pojoParamsApi} {@link #packetPojoParamsApi}
 * 
 * ����������б��������ʾ {@link #arrayParamTestApi}  {@link #listParamTestApi}
 * 
 * �Զ����쳣������ʱ�쳣�׳���ȫ���쳣������ʾ {@link #runtimeExceptionTestApi} {@link #customExceptionTestApi}
 * 
 * Json���ݽ�����ʾ {@link #jsonTestApi} {@link #jsonTestApi2} 
 * 
 * restful���Ľӿ���ʾ {@link #restfulApi} 
 * 
 * */
@Controller /*ʹ��ע������������*/
public class ItemController4 {
	
	
	@RequestMapping("queryItems4") /*������Ҫӳ���url*/
	public ModelAndView queryItems() throws Exception {
		List<Item> itemList = new ArrayList<Item>();
		
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
	
	/**
	 * Controller��������String��ʾ
	 * 
	 * @return ���ص�string����jsp view�ĵ�ַ��ע�⻹Ҫ������xml�ļ���������ǰ׺�ͺ�׺��
	 * */
	@RequestMapping("queryItems5") /*������Ҫӳ���url*/
	public String queryItems5(Model model) throws Exception {
		List<Item> itemList = new ArrayList<Item>();
		
		Item item1 = new Item();
		item1.setName("����ʼǱ�");
		item1.setDetail("����ʼǱ���������ʼǱ�");
		itemList.add(item1);
		
		Item item2 = new Item();
		item2.setName("ƻ���ֻ�");
		item2.setDetail("ƻ���ֻ�����ƻ���ֻ�");
		itemList.add(item2);
		
		/*����view���ݣ��൱��modelAndView.addObject("itemsList",itemList);*/
		model.addAttribute("itemsList", itemList);
		
		return "items/itemsList";
	}
	
	/**
	 * Controller��������String����ҳ���ض�����ʾ
	 * 
	 * @return ����redirect:ǰ׺���������ض���
	 * */
	@RequestMapping("redirectTestApi") /*������Ҫӳ���url*/
	public String redirectTestApi() throws Exception {
		return "redirect:successApi.action";
	}
	
	/**
	 * Controller��������String����ҳ��ת����ʾ
	 * ҳ��ת�����԰�����������뵽��ת��ҳ��
	 * 
	 * @return ����forward:ǰ׺��������ҳ��ת��
	 * */
	@RequestMapping("forwardTestApi") /*������Ҫӳ���url*/
	public String forwardTestApi() throws Exception {
		return "forward:successApi.action";
	}
	
	/**
	 * �ض����ҳ��ת��Ŀ��ӿ�
	 * */
	@RequestMapping("successApi") /*������Ҫӳ���url*/
	public String successApi(HttpServletRequest request) throws Exception {
		/*����������е�id��ӡ����*/
		System.out.println(request.getParameter("id")); /*ҳ��ת�����ܻ�ȡ���������ض�����*/
		return "success"; /*����success.jspҳ��*/
	}
	
	/**
	 * ����josn������ʾ
	 * @throws Exception 
	 * */
	@RequestMapping("returnJsonApi") /*������Ҫӳ���url*/
	public void returnJsonApi(HttpServletResponse response) throws Exception{
		/*ʹ�ô˷�ʽʵ��Handler����ͨ���޸�response��������Ҫ��Ӧ�����ݸ�ʽ��������Ӧjson����*/
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("{\"code\":100,\"data\":[],\"message\":\"��ȡ���ݳɹ�\"}");
	}
	
	/**���������ݲ�������ʾ��ֱ���ڲ������������ɰ�*/
	@RequestMapping("simpleParamsApi")
	public String simpleParamsApi(Integer id,String name){
		System.out.println(id + " " + name);
		return "success"; /*����success.jspҳ��*/
	}
	
	/**
	 * ����@RequestParamע����в�������ʾ
	 * 
	 * ע��@RequestParam˵����
	 * 	value�������󶨵Ĳ�������
	 * 	required���Ƿ�Ϊ�ش�
	 * 	defaultValue��Ĭ��ֵ
	 * 
	 * */
	@RequestMapping("annoParamsApi")
	public String annoParamsApi(@RequestParam(value="id",required=true,defaultValue="-1") Integer id){
		System.out.println(id);
		return "success"; /*����success.jspҳ��*/
	}
	
	/**
	 * @RequestMappingע��ʹ�÷�����ʾ
	 * 	method����������ʽ
	 * */
	@RequestMapping(value="requestMappingTestApi",method={RequestMethod.GET,RequestMethod.POST})
	public String requestMappingTestApi(){
		return "success";
	}
	
	/**
	 * Pojo�����������ʾ
	 * �󶨹��������д�����������ƺ�pojo�����еĳ�Ա��������һ�¼���
	 * ע�⣺pojo��������İ󶨿��Ժͷ����������Ĳ���ͬʱ�󶨣�����˵�������id����ͬʱ�󶨵��������id��item�����е�id
	 * 
	 * ���������ַ��http://localhost:8080/HelloSpringMVC/pojoParamsApi.action?name=ΤС��&id=123456
	 * */
	@RequestMapping("pojoParamsApi")
	public String pojoParamsApi(Integer id,Item item){
		System.out.println(id + " " + item.getId() + " " + item.getName());
		return "success";
	}
	
	/**
	 * ��װ����pojo��������ʾ
	 * ���������ַ��http://localhost:8080/HelloSpringMVC/packetPojoParamsApi.action?item.name=ΤС��&item2.name=Τ��
	 * */
	@RequestMapping("packetPojoParamsApi")
	public String packetPojoParamsApi(ItemVo itemVo){
		System.out.println("item.name:" + itemVo.getItem().getName() + " item2.name:" + itemVo.getItem2().getName());
		return "success";
	}
	
	/**
	 * ���鴫����ʾ
	 * ���������ַ��(GET) http://localhost:8080/HelloSpringMVC/arrayParamTestApi.action?ids=1&ids=2
	 * */
	@RequestMapping("arrayParamTestApi")
	public String arrayParamTestApi(Integer[] ids){
		for(Integer id:ids) System.out.println(id);
		return "success";
	}
	
	/**
	 * �б�����ʾ
	 * ���������ַ��
	 * 	GET�� http://localhost:8080/HelloSpringMVC/listParamTestApi.action?itemList[0].id=1&itemList[0].name=ΤС��&itemList[1].id=2&itemList[1].name=Τ����
	 * 
	 * 	POST: http://localhost:8080/HelloSpringMVC/listParamTestApi.action
	 * 			������:
	 * 				itemList[0].id=1
	 *				itemList[0].name=ΤС��
	 *				itemList[1].id=2
	 *				itemList[1].name=Τ����
	 * 
	 * */
	@RequestMapping("listParamTestApi")
	public String listParamTestApi(ItemVo itemVo){
		if(itemVo != null && itemVo.getItemList() != null) for(Item item:itemVo.getItemList()) System.out.println(item);
		return "success";
	}
	
	/**
	 * ����ʱ�쳣�ӿڲ���
	 * 
	 * ȫ���쳣�������ο�{@link} com.weicheng.exception.Hello}
	 * */
	@RequestMapping("runtimeExceptionTestApi")
	public String runtimeExceptionTestApi(ItemVo itemVo) throws Exception{
		int i = 12/0;
		return "success";
	}
	
	/**
	 * �Զ����쳣�ӿڲ���
	 * 
	 * ȫ���쳣�������ο�{@link} com.weicheng.exception.Hello}
	 * */
	@RequestMapping("customExceptionTestApi")
	public String customExceptionTestApi(ItemVo itemVo) throws Exception{
		if(true) throw new CustomException("�Զ����쳣�׳�����");
		return "success";
	}
	
	/**
	 * Json������ʾ������json������josn���ݣ���Ҫ�ȵ������jackson jar��
	 * ע�⣬����ͷ�е�Content-Type: application/json;charset=UTF-8
	 * 
	 * @param item ����@RequestBody��ǩ�Ѵ����json�ַ���ת��po����
	 * 
	 * @return ����һ��po����ת����json�ַ���
	 * */
	@RequestMapping(value="jsonTestApi",method={RequestMethod.POST})
	@ResponseBody()
	public Item jsonTestApi(@RequestBody Item item){
		item.setName("ΤС��");
		return item;
	}
	
	/**
	 * Json������ʾ������json���ݣ���Ҫ�ȵ������jackson jar��
	 * 
	 * @return ����һ��po����ת����json�ַ���
	 * */
	@RequestMapping("jsonTestApi2")
	@ResponseBody
	public Item jsonTestApi2(){
		Item item = new Item();
		item.setName("ΤС��");
		return item;
	}
	
	/**
	 * restful���Ľӿ���ʾ
	 * 
	 * ��Ҫ����web.xml�ļ�������restful����ǰ�˿�����
	 * 
	 * ���������ַ��http://localhost:8080/HelloSpringMVC/restfulApi/33/ΤС��
	 * */
	@RequestMapping("restfulApi/{id}/{name}")
	@ResponseBody
	public Item restfulApi(@PathVariable("id") Integer id,@PathVariable("name") String name){
		Item item = new Item();
		item.setId(id);
		item.setName(name);
		return item;
	}
	
}
