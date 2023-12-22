package com.muthu.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="name")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Product() {
		
	}

	public Product(String code, Double price, String name) {
		super();
		this.code = code;
		this.price = price;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", price=" + price + ", name=" + name + "]";
	}
	
	

}
