package com.weicheng.po;

import java.util.List;

/**传入参数类*/
public class ItemVo {

	/**第一个Item*/
	private Item item;
	
	/**第二个Item*/
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
