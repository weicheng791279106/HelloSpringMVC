package com.weicheng.po;

import java.util.List;

/**���������*/
public class ItemVo {

	/**��һ��Item*/
	private Item item;
	
	/**�ڶ���Item*/
	private Item item2;
	
	private List<Item> itemList;
	
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem2() {
		return item2;
	}

	public void setItem2(Item item2) {
		this.item2 = item2;
	}
	
}
