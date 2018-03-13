package com.weicheng.ssm.service;

import java.util.List;

import com.weicheng.ssm.po.ItemsCustom;
import com.weicheng.ssm.po.ItemsQueryVo;

public interface ItemsService {
	
	/**
	 * 查找所有商品或根据商品名称查询商品
	 * @param itemsQueryVo：若需要根据商品名称查找商品，则传入此对象，并且itemsCustom成员的name属性需要赋值，否则不传itemsQueryVo则查找所有商品
	 * */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	/**根据id查找商品*/
	public ItemsCustom findItemsById(Integer id /*用Integer方便判断非空*/) throws Exception;
	
	/**修改商品信息*/
	public void updateItems(Integer id /*用Integer方便判断非空*/,ItemsCustom itemsCustom) throws Exception;
	
}
