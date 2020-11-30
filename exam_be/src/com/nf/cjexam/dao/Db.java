package com.nf.cjexam.dao;

import java.util.HashMap;
import java.util.Map;

import com.nf.cjexam.entity.ProductItemEntity;

public class Db {
	private static  Map<Integer,ProductItemEntity> items ;
	
	
	static {
		items = new HashMap<>();
		for(int i=1;i<5;i++){
			ProductItemEntity item = new ProductItemEntity();
			item.setId(i);
			item.setDescription("desc:" + i);
			item.setTitle("title:" + i);
			item.setPrice(i*10.5);
			item.setQty(i*100);
			items.put(item.getId(), item);
		}
	}
	
	public static Map<Integer,ProductItemEntity> getItems() {
		return items;
	}
}
