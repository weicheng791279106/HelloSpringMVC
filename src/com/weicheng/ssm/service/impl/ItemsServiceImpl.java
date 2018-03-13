package com.weicheng.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.weicheng.ssm.mapper.ItemsMapper;
import com.weicheng.ssm.mapper.ItemsMapperCustom;
import com.weicheng.ssm.po.Items;
import com.weicheng.ssm.po.ItemsCustom;
import com.weicheng.ssm.po.ItemsQueryVo;
import com.weicheng.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{

	@Autowired /*因为在applicationContext-dao.xml文件中开启了mapper扫描，所以这里可以对未声明的ItemsMapperCustom.class进行注入*/
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired /*因为在applicationContext-dao.xml文件中开启了mapper扫描，所以这里可以对未声明的ItemsMapperCustom.class进行注入*/
	private ItemsMapper itemsMapper;
	
	@Override
	/**
	 * 查找所有商品或根据商品名称查询商品
	 * @param itemsQueryVo：若需要根据商品名称查找商品，则传入此对象，并且itemsCustom成员的name属性需要赋值，否则不传itemsQueryVo则查找所有商品
	 * */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	/**根据id查找商品*/
	public ItemsCustom findItemsById(Integer id) throws Exception {
		/*查询商品信息*/
		Items items = itemsMapper.selectByPrimaryKey(id);
		/*可以对查询出来的信息做业务处理，将结果放入到ItemsCustom中*/
		ItemsCustom itemsCustom = new ItemsCustom();
		/*拷贝属性*/
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	/**修改商品信息*/
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		/*TODO:对id进行参数校验，如果校验不通过抛出Exception*/
		
		/*updateByPrimaryKeyWithBLOBs()方法要求传入的Items对象必须要有id属性*/
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	
	

}
