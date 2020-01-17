package com.spr.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue
	private int productId;
	@Column(name = "product_name")
	private String productName;
	private float price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(int productId) {
		super();
		this.productId = productId;
	}


	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
