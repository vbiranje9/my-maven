package com.spr.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spr.dao.ProductDao;
import com.spr.dto.Product;
import com.spr.serv.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/product_add_form")
	public String prepProductAddform(ModelMap model) {
		model.put("product", new Product());
		return "product_add_form";
	}
	
	@RequestMapping(value = "/product_add")
	public String addProduct(Product product,ModelMap model) {
		productService.add(product);
		model.put("product", new Product());
		return "product_add_form";
	}
	
	@RequestMapping(value = "/product_list")
	public String productList(ModelMap model) {
		List<Product> plist = productService.selectAll();
		model.put("productList", plist);
		return "product_list";
	}
	
	@RequestMapping(value = "/product_delete")
	public String productDelete(@RequestParam int productId, ModelMap model) {
		productService.remove(productId);
		List<Product> plist = productService.selectAll();
		model.put("productList", plist);
		return "product_list";
	}
	
	@RequestMapping(value = "/product_update_form")
	public String productSelect(@RequestParam int productId, ModelMap model) {
		Product product = productService.selectById(productId);
		model.put("product", product);
		return "product_update_form";
	}
	
	@RequestMapping(value = "/product_update")
	public String productDelete(Product product, ModelMap model) {
		productService.edit(product);
		List<Product> plist = productService.selectAll();
		model.put("productList", plist);
		return "product_list";
	}
	
}
