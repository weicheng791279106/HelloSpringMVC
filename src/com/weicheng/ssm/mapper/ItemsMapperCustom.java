package com.weicheng.ssm.mapper;

import java.util.List;

import com.weicheng.ssm.po.ItemsCustom;
import com.weicheng.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {

	
	/**
	 * ����������Ʒ�������Ʒ���Ʋ�ѯ��Ʒ
	 * @param itemsQueryVo������Ҫ������Ʒ���Ʋ�����Ʒ������˶��󣬲���itemsCustom��Ա��name������Ҫ��ֵ�����򲻴�itemsQueryVo�����������Ʒ
	 * */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo ) throws Exception;
	
}
