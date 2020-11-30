package com.nf.cjexam.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.nf.cjexam.entity.ProductItemEntity;

public class ProductDao {
	public List<ProductItemEntity> getAll() {
		return Db.getItems().values().stream().collect(Collectors.toList());
	}

	public ProductItemEntity getById(int id) {
		return Db.getItems().get(id);
	}

	public boolean deleteItemById(int id) {

		int key = getKeyById(id);
		if (key == -1)
			return false;

		return Db.getItems().remove(key) == null ? false : true;
	}

	private int getKeyById(int id) {
		int result = -1;
		for (Map.Entry<Integer, ProductItemEntity> p : Db.getItems().entrySet()) {
			if (p.getValue().getId().equals(id)) {
				result = p.getKey();
			}
		}
		return result;
	}

	public boolean update(ProductItemEntity item) {

		return Db.getItems().put(item.getId(), item) == null ? false : true;
	}

	public boolean add(ProductItemEntity item) {
		if (Db.getItems().containsKey(item.getId()))
			return false;

		Db.getItems().put(item.getId(), item);
		return true;
	}
}
