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
 * 注解方式实现Handler演示 {@link #queryItems4}
 * 
 * 页面重定向，页面转发演示 {@link #redirectTestApi} {@link #forwardTestApi}
 * 
 * 返回json数据演示 {@link #returnJsonApi}
 * 
 * 数据绑定演示：包括简单数据类型绑定演示，利用@RequestParam注解进行数据绑定演示 {@link #simpleParamsApi} {@link #annoParamsApi}
 * 
 * 使用@RequestMapping注解限制请求方式演示 {@link #requestMappingTestApi}
 * 
 * Pojo对象参数绑定演示及包装类型pojo参数绑定演示 {@link #pojoParamsApi} {@link #packetPojoParamsApi}
 * 
 * 数组参数，列表参数绑定演示 {@link #arrayParamTestApi}  {@link #listParamTestApi}
 * 
 * 自定义异常，运行时异常抛出及全局异常处理演示 {@link #runtimeExceptionTestApi} {@link #customExceptionTestApi}
 * 
 * Json数据交互演示 {@link #jsonTestApi} {@link #jsonTestApi2} 
 * 
 * restful风格的接口演示 {@link #restfulApi} 
 * 
 * */
@Controller /*使用注解声明控制器*/
public class ItemController4 {
	
	
	@RequestMapping("queryItems4") /*声明需要映射的url*/
	public ModelAndView queryItems() throws Exception {
		List<Item> itemList = new ArrayList<Item>();
		
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
	
	/**
	 * Controller方法返回String演示
	 * 
	 * @return 返回的string就是jsp view的地址（注意还要加上在xml文件中声明的前缀和后缀）
	 * */
	@RequestMapping("queryItems5") /*声明需要映射的url*/
	public String queryItems5(Model model) throws Exception {
		List<Item> itemList = new ArrayList<Item>();
		
		Item item1 = new Item();
		item1.setName("联想笔记本");
		item1.setDetail("联想笔记本就是联想笔记本");
		itemList.add(item1);
		
		Item item2 = new Item();
		item2.setName("苹果手机");
		item2.setDetail("苹果手机就是苹果手机");
		itemList.add(item2);
		
		/*设置view内容，相当于modelAndView.addObject("itemsList",itemList);*/
		model.addAttribute("itemsList", itemList);
		
		return "items/itemsList";
	}
	
	/**
	 * Controller方法返回String进行页面重定向演示
	 * 
	 * @return 利用redirect:前缀进行请求重定向
	 * */
	@RequestMapping("redirectTestApi") /*声明需要映射的url*/
	public String redirectTestApi() throws Exception {
		return "redirect:successApi.action";
	}
	
	/**
	 * Controller方法返回String进行页面转发演示
	 * 页面转发可以把请求参数带入到被转发页面
	 * 
	 * @return 利用forward:前缀进行请求页面转发
	 * */
	@RequestMapping("forwardTestApi") /*声明需要映射的url*/
	public String forwardTestApi() throws Exception {
		return "forward:successApi.action";
	}
	
	/**
	 * 重定向或页面转发目标接口
	 * */
	@RequestMapping("successApi") /*声明需要映射的url*/
	public String successApi(HttpServletRequest request) throws Exception {
		/*把请求参数中的id打印出来*/
		System.out.println(request.getParameter("id")); /*页面转发才能获取到参数，重定向不行*/
		return "success"; /*返回success.jsp页面*/
	}
	
	/**
	 * 返回josn数据演示
	 * @throws Exception 
	 * */
	@RequestMapping("returnJsonApi") /*声明需要映射的url*/
	public void returnJsonApi(HttpServletResponse response) throws Exception{
		/*使用此方式实现Handler可以通过修改response来设置需要相应的数据格式，比如相应json数据*/
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("{\"code\":100,\"data\":[],\"message\":\"获取数据成功\"}");
	}
	
	/**简单类型数据参数绑定演示：直接在参数中声明即可绑定*/
	@RequestMapping("simpleParamsApi")
	public String simpleParamsApi(Integer id,String name){
		System.out.println(id + " " + name);
		return "success"; /*返回success.jsp页面*/
	}
	
	/**
	 * 利用@RequestParam注解进行参数绑定演示
	 * 
	 * 注解@RequestParam说明：
	 * 	value：参数绑定的参数名称
	 * 	required：是否为必传
	 * 	defaultValue：默认值
	 * 
	 * */
	@RequestMapping("annoParamsApi")
	public String annoParamsApi(@RequestParam(value="id",required=true,defaultValue="-1") Integer id){
		System.out.println(id);
		return "success"; /*返回success.jsp页面*/
	}
	
	/**
	 * @RequestMapping注解使用方法演示
	 * 	method：限制请求方式
	 * */
	@RequestMapping(value="requestMappingTestApi",method={RequestMethod.GET,RequestMethod.POST})
	public String requestMappingTestApi(){
		return "success";
	}
	
	/**
	 * Pojo对象参数绑定演示
	 * 绑定规则：请求中传入参数的名称和pojo对象中的成员变量名称一致即绑定
	 * 注意：pojo对象参数的绑定可以和方法中声明的参数同时绑定，就是说请求参数id可以同时绑定到传入参数id和item对象中的id
	 * 
	 * 测试请求地址：http://localhost:8080/HelloSpringMVC/pojoParamsApi.action?name=韦小宝&id=123456
	 * */
	@RequestMapping("pojoParamsApi")
	public String pojoParamsApi(Integer id,Item item){
		System.out.println(id + " " + item.getId() + " " + item.getName());
		return "success";
	}
	
	/**
	 * 包装类型pojo参数绑定演示
	 * 测试请求地址：http://localhost:8080/HelloSpringMVC/packetPojoParamsApi.action?item.name=韦小宝&item2.name=韦大宝
	 * */
	@RequestMapping("packetPojoParamsApi")
	public String packetPojoParamsApi(ItemVo itemVo){
		System.out.println("item.name:" + itemVo.getItem().getName() + " item2.name:" + itemVo.getItem2().getName());
		return "success";
	}
	
	/**
	 * 数组传参演示
	 * 测试请求地址：(GET) http://localhost:8080/HelloSpringMVC/arrayParamTestApi.action?ids=1&ids=2
	 * */
	@RequestMapping("arrayParamTestApi")
	public String arrayParamTestApi(Integer[] ids){
		for(Integer id:ids) System.out.println(id);
		return "success";
	}
	
	/**
	 * 列表传参演示
	 * 测试请求地址：
	 * 	GET： http://localhost:8080/HelloSpringMVC/listParamTestApi.action?itemList[0].id=1&itemList[0].name=韦小宝&itemList[1].id=2&itemList[1].name=韦二宝
	 * 
	 * 	POST: http://localhost:8080/HelloSpringMVC/listParamTestApi.action
	 * 			请求体:
	 * 				itemList[0].id=1
	 *				itemList[0].name=韦小宝
	 *				itemList[1].id=2
	 *				itemList[1].name=韦二宝
	 * 
	 * */
	@RequestMapping("listParamTestApi")
	public String listParamTestApi(ItemVo itemVo){
		if(itemVo != null && itemVo.getItemList() != null) for(Item item:itemVo.getItemList()) System.out.println(item);
		return "success";
	}
	
	/**
	 * 运行时异常接口测试
	 * 
	 * 全局异常处理方法参考{@link} com.weicheng.exception.Hello}
	 * */
	@RequestMapping("runtimeExceptionTestApi")
	public String runtimeExceptionTestApi(ItemVo itemVo) throws Exception{
		int i = 12/0;
		return "success";
	}
	
	/**
	 * 自定义异常接口测试
	 * 
	 * 全局异常处理方法参考{@link} com.weicheng.exception.Hello}
	 * */
	@RequestMapping("customExceptionTestApi")
	public String customExceptionTestApi(ItemVo itemVo) throws Exception{
		if(true) throw new CustomException("自定义异常抛出测试");
		return "success";
	}
	
	/**
	 * Json交互演示，传入json，返回josn数据，需要先导入相关jackson jar包
	 * 注意，请求头中的Content-Type: application/json;charset=UTF-8
	 * 
	 * @param item 利用@RequestBody标签把传入的json字符串转成po对象
	 * 
	 * @return 返回一个po对象转化的json字符串
	 * */
	@RequestMapping(value="jsonTestApi",method={RequestMethod.POST})
	@ResponseBody()
	public Item jsonTestApi(@RequestBody Item item){
		item.setName("韦小宝");
		return item;
	}
	
	/**
	 * Json交互演示，返回json数据，需要先导入相关jackson jar包
	 * 
	 * @return 返回一个po对象转化的json字符串
	 * */
	@RequestMapping("jsonTestApi2")
	@ResponseBody
	public Item jsonTestApi2(){
		Item item = new Item();
		item.setName("韦小宝");
		return item;
	}
	
	/**
	 * restful风格的接口演示
	 * 
	 * 需要先在web.xml文件中配置restful风格的前端控制器
	 * 
	 * 测试请求地址：http://localhost:8080/HelloSpringMVC/restfulApi/33/韦小宝
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
