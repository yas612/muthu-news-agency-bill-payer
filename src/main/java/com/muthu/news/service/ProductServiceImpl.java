package com.muthu.news.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.muthu.news.Product;
import com.muthu.news.User;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.converter.CodeAndTamilLangHandler;
import com.muthu.news.exception.CustomException;
import com.muthu.news.mapper.ProductRowMapper;
import com.muthu.news.mapper.UserRowMapper;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	private CodeAndTamilLangHandler handler = new CodeAndTamilLangHandler();

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAll() throws CustomException {
		logger.info("Fetching all Papers");
		List<Product> products = null;
		try {
			products = jdbcTemplate.query(MuthuConstants.GET_ALL_PRODUCT, new ProductRowMapper());
		} catch (Exception e) {
			logger.error("ERROR occurred while fetching all papers.");
			logger.error(e.getMessage());
		}
		if (products == null) {
			logger.error("Fetched 0 papers.");
			return null;
		}
		logger.info("Fetched papers count : " + products.size());
		return products;
	}

	@Override
	public Product addProduct(Product product) {
		//String encodedCode = handler.tamilToUnicode(product.getCode());
		try {
			logger.info("Adding NEW paper with details : " + product.toString());
			jdbcTemplate.update(MuthuConstants.ADD_PRODUCT,
					new Object[] { product.getCode(), product.getName(), product.getPrice() });
		} catch (Exception e) {
			logger.error("ERROR occurred while adding paper");
			logger.error(e.getMessage());
			return null;
		}
		logger.info("SUCCESSFULLY added product with details : " + product.toString());
		return product;
	}

	@Override
	public Product updateProduct(Product product, Double difference) throws CustomException {
		logger.info("Updating a paper with details : " + product.toString() + " with updated price : " + difference);
		try {
			jdbcTemplate.update(MuthuConstants.UPDATE_PRODUCT, new Object[] { product.getPrice(), product.getCode() });
			handleAffectedUsersForUpdate(product.getCode(), difference);
		} catch (Exception e) {
			logger.error("Error occurred while updating paper");
			logger.error(e.getMessage());
		}
		return product;
	}

	@Override
	public Boolean remProduct(String code) {
		Boolean decider = false;
		logger.info("Request to remove a paper with code : " + code);
		try {
			decider = jdbcTemplate.update(MuthuConstants.DEL_PRODUCT, new Object[] { code }) == 1;
		} catch (Exception e) {
			logger.error("Error occurred while removing paper");
			logger.error(e.getMessage());
		}
		return decider;
	}

	@Override
	public Product getAProduct(String code) {
		Product product = null;
		try {
			product = jdbcTemplate.queryForObject(MuthuConstants.GET_PRODUCT_BY_CODE, new Object[] { code },
					new ProductRowMapper());
		} catch (Exception e) {
			logger.error("Error occurred while fetching a paper with code : " + code);
			logger.error(e.getMessage());
		}
		return product;
	}

	public void handleAffectedUsersForUpdate(String code, Double price) {
		List<User> affectedUsers = null;
		logger.info("Handling affected users");
		try {
			affectedUsers = jdbcTemplate.query(MuthuConstants.AFFETCTED_USERS.replace("param", code),
					new UserRowMapper());
			logger.info("Total affected users : " + affectedUsers.size());
		} catch (Exception e) {
			logger.error("ERROR occurred while fetching affected users");
			logger.error(e.getMessage());
		}
		for (User user : affectedUsers) {
			user.setBill(user.getBill() + price);
			try {
				jdbcTemplate.update(MuthuConstants.UPDATE_USER_BILL, new Object[] { user.getBill(), user.getMob() });
			} catch (Exception e) {
				logger.error("ERROR occurred while updating the affected user with detail : " + user.toString());
				logger.error(e.getMessage());
			}
		}
	}

}
