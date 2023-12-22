package com.muthu.news.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.muthu.news.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setCode(rs.getString("code"));
		product.setName(rs.getString("name"));
	    product.setPrice(rs.getDouble("price"));
		return product;
		
	}

}
