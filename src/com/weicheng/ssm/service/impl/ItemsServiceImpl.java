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

	@Autowired /*��Ϊ��applicationContext-dao.xml�ļ��п�����mapperɨ�裬����������Զ�δ������ItemsMapperCustom.class����ע��*/
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired /*��Ϊ��applicationContext-dao.xml�ļ��п�����mapperɨ�裬����������Զ�δ������ItemsMapperCustom.class����ע��*/
	private ItemsMapper itemsMapper;
	
	@Override
	/**
	 * ����������Ʒ�������Ʒ���Ʋ�ѯ��Ʒ
	 * @param itemsQueryVo������Ҫ������Ʒ���Ʋ�����Ʒ������˶��󣬲���itemsCustom��Ա��name������Ҫ��ֵ�����򲻴�itemsQueryVo�����������Ʒ
	 * */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	/**����id������Ʒ*/
	public ItemsCustom findItemsById(Integer id) throws Exception {
		/*��ѯ��Ʒ��Ϣ*/
		Items items = itemsMapper.selectByPrimaryKey(id);
		/*���ԶԲ�ѯ��������Ϣ��ҵ������������뵽ItemsCustom��*/
		ItemsCustom itemsCustom = new ItemsCustom();
		/*��������*/
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	/**�޸���Ʒ��Ϣ*/
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		/*TODO:��id���в���У�飬���У�鲻ͨ���׳�Exception*/
		
		/*updateByPrimaryKeyWithBLOBs()����Ҫ�����Items�������Ҫ��id����*/
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	
	

}
