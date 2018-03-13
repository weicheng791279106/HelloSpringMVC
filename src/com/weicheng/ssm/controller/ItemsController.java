package com.weicheng.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.weicheng.ssm.po.ItemsCustom;
import com.weicheng.ssm.po.ItemsQueryVo;
import com.weicheng.ssm.service.ItemsService;

/**商品业务相关Controller*/
@Controller
@RequestMapping("items/") /*为了对url进行分类管理，可以在这里用@RequestMapping注解定义根路径，最终访问url是根路径+子路径，这叫"窄化请求映射"*/
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	/**
	 * 查找所有商品或根据商品名称查询商品
	 * @param itemsQueryVo：若需要根据商品名称查找商品，则传入此对象，并且itemsCustom成员的name属性需要赋值，否则不传itemsQueryVo则查找所有商品
	 * */
	@RequestMapping("queryItems") /*声明需要映射的url*/
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
		/*调用service从数据库中查询商品列表，如果itemsQueryVo为null则查找所有商品*/
		List<ItemsCustom> itemList = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		/*设置modelAndView的属性，在jsp页面中将属性读取出来显示，所以这里的属性名称要与jsp页面中的属性名称对应*/
		modelAndView.addObject("itemsList",itemList);
		/*指定视图*/
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp"); //完整View地址演示
		modelAndView.setViewName("items/itemsList"); //由于在配置文件中配置了视图路径的前后缀，所以这里不必写完整地址
		return modelAndView;
	}
	
	/**获取修改商品信息页面（查询商品详情）*/
	@RequestMapping("editItems")
	public ModelAndView editItem(Integer id) throws Exception{
		/*查询商品详情*/
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsCustom",itemsCustom);
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}
	
	/**
	 * 修改商品信息
	 * 
	 * #关键点：
	 * 	1、图片上传，需要导入commons-fileupload-1.2.2.jar和commons-io.-2.4.jar包，并且在springmvc.xml中配置文件上传，还需要配置tomcat的虚路径
	 * 	2、日期类型的参数绑定，将itemsCustom中的createtime解析（String解析成Date类型） {@link com.weicheng.ssm.converter.CustomDateConverter}
	 * 
	 * 由于在ItemsCustom类中存在Date类型的成员变量，所以在接收参数的时候需要使用自定义的日期转换器将String类型的日期转化成Date类型，
	 * 具体实现请参考springmvc.xml文件中的参数转换器配置
	 * */
	@RequestMapping("editItemsSubmit")
	public ModelAndView editItemsSubmit(Integer id,ItemsCustom itemsCustom,/*图片上传*/MultipartFile pictureFile) throws Exception{
		
		/*接收上传上来的图片*/
		if(pictureFile != null){
			/*存储路径*/
			String savePath = "F:\\EclipseWorkSpace\\HelloSpringMVC\\temp\\";
			/*拿到原始名称*/
			String oldFileName = pictureFile.getOriginalFilename();
			if(oldFileName != null && !oldFileName.equals("")){ /*判断文件名是否非空*/
				/*用UUID设置新名称防止名称重复*/
				String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
				File imageFile = new File(savePath + newFileName);
				/*将图片存到指定文件中*/
				pictureFile.transferTo(imageFile);
				/*保存文件路径（相对路径）*/
				itemsCustom.setPic(newFileName);
			}
		}
		
		/*调用service更新商品信息*/
		itemsService.updateItems(id, itemsCustom);
		
		/*返回一个请求成功页面*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	/**批量删除商品，请求参数示例：(GET) http://localhost:8080/HelloSpringMVC/item/deleteItems.action?itemIds=1&itemIds=2*/
	@RequestMapping("deleteItems")
	public String deleteItems(Integer[] itemIds) throws Exception{
		/*TODO:调用service删除商品*/
		return "success";
	}
	
	/**
	 * 获取批量修改商品页面
	 * @param itemsQueryVo：若需要根据商品名称查找商品，则传入此对象，并且itemsCustom成员的name属性需要赋值，否则不传itemsQueryVo则查找所有商品
	 * */
	@RequestMapping("editItemsQuery") /*声明需要映射的url*/
	public ModelAndView editItemsQuery(ItemsQueryVo itemsQueryVo) throws Exception {
		/*调用service从数据库中查询商品列表，如果itemsQueryVo为null则查找所有商品*/
		List<ItemsCustom> itemList = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		/*设置modelAndView的属性，在jsp页面中将属性读取出来显示，所以这里的属性名称要与jsp页面中的属性名称对应*/
		modelAndView.addObject("itemsList",itemList);
		/*指定视图*/
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp"); //完整View地址演示
		modelAndView.setViewName("items/editItemsQuery"); //由于在配置文件中配置了视图路径的前后缀，所以这里不必写完整地址
		return modelAndView;
	}
	
	/**批量修改商品提交*/
	@RequestMapping("editItemsAllSubmit") /*声明需要映射的url*/
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		/*TODO:调用dao层修改商品*/
		return "success";
	}
	
	

}














