package com.weicheng.ssm.po;

import java.util.List;

/**��ѯItems���������*/
public class ItemsQueryVo {

	/**��Ʒ��Ϣ*/
	private Items items;
	/**Ϊ�˿���չ�ԣ���ԭʼ���ɵ�po������չ*/
	private ItemsCustom itemsCustom;
	/**������Ʒ��Ϣ*/
	private List<ItemsCustom> itemsList;
	
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
}
