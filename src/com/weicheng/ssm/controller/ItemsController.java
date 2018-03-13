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

/**��Ʒҵ�����Controller*/
@Controller
@RequestMapping("items/") /*Ϊ�˶�url���з������������������@RequestMappingע�ⶨ���·�������շ���url�Ǹ�·��+��·�������"խ������ӳ��"*/
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	/**
	 * ����������Ʒ�������Ʒ���Ʋ�ѯ��Ʒ
	 * @param itemsQueryVo������Ҫ������Ʒ���Ʋ�����Ʒ������˶��󣬲���itemsCustom��Ա��name������Ҫ��ֵ�����򲻴�itemsQueryVo�����������Ʒ
	 * */
	@RequestMapping("queryItems") /*������Ҫӳ���url*/
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
		/*����service�����ݿ��в�ѯ��Ʒ�б����itemsQueryVoΪnull�����������Ʒ*/
		List<ItemsCustom> itemList = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		/*����modelAndView�����ԣ���jspҳ���н����Զ�ȡ������ʾ�������������������Ҫ��jspҳ���е��������ƶ�Ӧ*/
		modelAndView.addObject("itemsList",itemList);
		/*ָ����ͼ*/
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp"); //����View��ַ��ʾ
		modelAndView.setViewName("items/itemsList"); //�����������ļ�����������ͼ·����ǰ��׺���������ﲻ��д������ַ
		return modelAndView;
	}
	
	/**��ȡ�޸���Ʒ��Ϣҳ�棨��ѯ��Ʒ���飩*/
	@RequestMapping("editItems")
	public ModelAndView editItem(Integer id) throws Exception{
		/*��ѯ��Ʒ����*/
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsCustom",itemsCustom);
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 * 
	 * #�ؼ��㣺
	 * 	1��ͼƬ�ϴ�����Ҫ����commons-fileupload-1.2.2.jar��commons-io.-2.4.jar����������springmvc.xml�������ļ��ϴ�������Ҫ����tomcat����·��
	 * 	2���������͵Ĳ����󶨣���itemsCustom�е�createtime������String������Date���ͣ� {@link com.weicheng.ssm.converter.CustomDateConverter}
	 * 
	 * ������ItemsCustom���д���Date���͵ĳ�Ա�����������ڽ��ղ�����ʱ����Ҫʹ���Զ��������ת������String���͵�����ת����Date���ͣ�
	 * ����ʵ����ο�springmvc.xml�ļ��еĲ���ת��������
	 * */
	@RequestMapping("editItemsSubmit")
	public ModelAndView editItemsSubmit(Integer id,ItemsCustom itemsCustom,/*ͼƬ�ϴ�*/MultipartFile pictureFile) throws Exception{
		
		/*�����ϴ�������ͼƬ*/
		if(pictureFile != null){
			/*�洢·��*/
			String savePath = "F:\\EclipseWorkSpace\\HelloSpringMVC\\temp\\";
			/*�õ�ԭʼ����*/
			String oldFileName = pictureFile.getOriginalFilename();
			if(oldFileName != null && !oldFileName.equals("")){ /*�ж��ļ����Ƿ�ǿ�*/
				/*��UUID���������Ʒ�ֹ�����ظ�*/
				String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
				File imageFile = new File(savePath + newFileName);
				/*��ͼƬ�浽ָ���ļ���*/
				pictureFile.transferTo(imageFile);
				/*�����ļ�·�������·����*/
				itemsCustom.setPic(newFileName);
			}
		}
		
		/*����service������Ʒ��Ϣ*/
		itemsService.updateItems(id, itemsCustom);
		
		/*����һ������ɹ�ҳ��*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	/**����ɾ����Ʒ���������ʾ����(GET) http://localhost:8080/HelloSpringMVC/item/deleteItems.action?itemIds=1&itemIds=2*/
	@RequestMapping("deleteItems")
	public String deleteItems(Integer[] itemIds) throws Exception{
		/*TODO:����serviceɾ����Ʒ*/
		return "success";
	}
	
	/**
	 * ��ȡ�����޸���Ʒҳ��
	 * @param itemsQueryVo������Ҫ������Ʒ���Ʋ�����Ʒ������˶��󣬲���itemsCustom��Ա��name������Ҫ��ֵ�����򲻴�itemsQueryVo�����������Ʒ
	 * */
	@RequestMapping("editItemsQuery") /*������Ҫӳ���url*/
	public ModelAndView editItemsQuery(ItemsQueryVo itemsQueryVo) throws Exception {
		/*����service�����ݿ��в�ѯ��Ʒ�б����itemsQueryVoΪnull�����������Ʒ*/
		List<ItemsCustom> itemList = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		/*����modelAndView�����ԣ���jspҳ���н����Զ�ȡ������ʾ�������������������Ҫ��jspҳ���е��������ƶ�Ӧ*/
		modelAndView.addObject("itemsList",itemList);
		/*ָ����ͼ*/
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp"); //����View��ַ��ʾ
		modelAndView.setViewName("items/editItemsQuery"); //�����������ļ�����������ͼ·����ǰ��׺���������ﲻ��д������ַ
		return modelAndView;
	}
	
	/**�����޸���Ʒ�ύ*/
	@RequestMapping("editItemsAllSubmit") /*������Ҫӳ���url*/
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		/*TODO:����dao���޸���Ʒ*/
		return "success";
	}
	
	

}














