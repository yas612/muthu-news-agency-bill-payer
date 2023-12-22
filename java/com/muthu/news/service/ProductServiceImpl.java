package com.muthu.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.muthu.news.Product;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.exception.CustomException;
import com.muthu.news.mapper.ProductRowMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAll() throws CustomException {
		List<Product> product = jdbcTemplate.query(MuthuConstants.GET_ALL_PRODUCT, new ProductRowMapper());
		if(product == null) {
			
			return null;
		}
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		try {
			jdbcTemplate.update(MuthuConstants.ADD_PRODUCT, new Object[] {product.getCode(), 
					product.getName(), product.getPrice()});
		}
		catch(Exception e) {
			return null;
		}
		return product;
	}

	@Override
	public Product updateProduct(Product product) throws CustomException {
		try {
			jdbcTemplate.update(MuthuConstants.UPDATE_PRODUCT, new Object[] {product.getPrice(), product.getCode()});
		}
		catch(Exception e) {
			return null;
		}
		return product;
	}

	@Override
	public Boolean remProduct(String code) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(MuthuConstants.DEL_PRODUCT,new Object[] {code}) == 1;
	}

	@Override
	public Product getAProduct(String code) {
		Product product = jdbcTemplate.queryForObject(MuthuConstants.GET_PRODUCT_BY_CODE, new Object[] {code}, 
				new ProductRowMapper());
		return product;
	}

}
