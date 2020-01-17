package com.spr.dao;

import java.util.List;

import com.spr.dto.Product;

public interface ProductDao {
	void add(Product product);
	void remove(int productId);
	void edit(Product product);
	Product selectById(int productId);
	List<Product> selectAll();
	
}
