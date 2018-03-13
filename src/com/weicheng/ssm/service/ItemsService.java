package com.weicheng.ssm.service;

import java.util.List;

import com.weicheng.ssm.po.ItemsCustom;
import com.weicheng.ssm.po.ItemsQueryVo;

public interface ItemsService {
	
	/**
	 * ����������Ʒ�������Ʒ���Ʋ�ѯ��Ʒ
	 * @param itemsQueryVo������Ҫ������Ʒ���Ʋ�����Ʒ������˶��󣬲���itemsCustom��Ա��name������Ҫ��ֵ�����򲻴�itemsQueryVo�����������Ʒ
	 * */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	/**����id������Ʒ*/
	public ItemsCustom findItemsById(Integer id /*��Integer�����жϷǿ�*/) throws Exception;
	
	/**�޸���Ʒ��Ϣ*/
	public void updateItems(Integer id /*��Integer�����жϷǿ�*/,ItemsCustom itemsCustom) throws Exception;
	
}
