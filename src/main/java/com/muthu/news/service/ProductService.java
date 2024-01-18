package com.muthu.news.service;

import java.util.List;

import com.muthu.news.Product;
import com.muthu.news.exception.CustomException;

public interface ProductService {
	
	public List<Product> getAll() throws CustomException;
	public Product addProduct(Product product);
	public Product updateProduct(Product product, Double diff) throws CustomException;
	public Boolean remProduct(String code);
	public Product getAProduct(String code);

}
