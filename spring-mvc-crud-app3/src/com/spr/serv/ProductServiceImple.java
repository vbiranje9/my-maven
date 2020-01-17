package com.spr.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.dao.ProductDao;
import com.spr.dto.Product;

@Service
public class ProductServiceImple implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void add(Product product) {
		productDao.add(product);	
	}

	@Override
	public void remove(int productId) {
		productDao.remove(productId);
	}

	@Override
	public void edit(Product product) {
		productDao.edit(product);
	}

	@Override
	public Product selectById(int productId) {
		// TODO Auto-generated method stub
		return productDao.selectById(productId);
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return productDao.selectAll();
	}

}
