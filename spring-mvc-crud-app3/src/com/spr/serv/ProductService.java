package com.spr.serv;

import java.util.List;

import com.spr.dto.Product;

public interface ProductService {
	void add(Product product);
	void remove(int productId);
	void edit(Product product);
	Product selectById(int productId);
	List<Product> selectAll();
}
