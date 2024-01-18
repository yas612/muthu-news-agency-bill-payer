package com.muthu.news.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.muthu.news.Product;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.exception.CustomException;
import com.muthu.news.service.ProductService;

@RestController
@RequestMapping("/admin/product")
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService service;

	@RequestMapping("/all")
	public ModelAndView productPage() throws CustomException {
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.PRODUCT_PAGE);
		List<Product> productlist = service.getAll();
		if (productlist == null) {
			mView.addObject(MuthuConstants.ERROR_MSG, MuthuConstants.ALL_PRODUCTS_FETCH_ERROR);
			return mView;
		} else {
			mView.addObject("productlist", productlist);
			return mView;
		}
	}

	@RequestMapping("/all/addproductPage")
	public ModelAndView addUserPage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.ADD_PRODUCT_PAGE);
		return mView;
	}

	@RequestMapping("/all/addProduct")
	public ModelAndView addProduct(@RequestParam(MuthuConstants.CODE) String code, 
			@RequestParam(MuthuConstants.NAME) String name, @RequestParam(MuthuConstants.PRICE) Double price) {
		Product product = new Product();
		product.setCode(code);
		product.setName(name);
		product.setPrice(price);
		Product verifier = service.addProduct(product);
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.ADD_PRODUCT_PAGE);
		if (verifier == null) {
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.ADD_PRODUCT_ERROR_MSG, 
					product.toString()));
		} else {
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.ADD_PRODUCT_SUCCESS_MSG, 
					product.toString()));
			mView.addObject("product", product);
		}
		return mView;
	}

	@RequestMapping("/all/editPage/editProduct")
	public ModelAndView editProduct(@RequestParam(MuthuConstants.CODE) String code, @RequestParam(MuthuConstants.NAME) 
	String name, @RequestParam(MuthuConstants.PRICE) Double price, @RequestParam(MuthuConstants.PREVIOUS_PRICE) 
	Double previousPrice) throws CustomException {
		Product product = new Product();
		product.setCode(code);
		product.setName(name);
		product.setPrice(price);
		logger.info("Request to update a paper, previous price : "+previousPrice+ " & NEW price : "+price);
		Product verifier = service.updateProduct(product, (price - previousPrice));
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.EDIT_PRODUCT_PAGE);
		if (verifier == null) {
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.EDIT_PRODUCT_ERROR_MSG, product.toString()));
		} else {
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.EDIT_PRODUCT_SUCCESS_MSG, product.toString()));
			mView.addObject("product", product);
		}
		return mView;

	}

	@RequestMapping("/all/delPage/delProduct")
	public ModelAndView delProduct(@RequestParam String code) throws CustomException {
		Boolean decider = service.remProduct(code);
		ModelAndView mView = new ModelAndView();
		if (decider) {
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.DEL_PRODUCT_SUCCESS_MSG, code));
		} else {
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.DEL_PRODUCT_ERROR_MSG, code));
		}
		mView.setViewName(MuthuConstants.DEL_PRODUCT_PAGE);
		return mView;
	}

	@RequestMapping("/all/delPage/{code}")
	public ModelAndView delProductPage(@PathVariable String code) {
		Product product = service.getAProduct(code);
		ModelAndView mView = new ModelAndView();
		mView.addObject("code", product.getCode());
		mView.setViewName(MuthuConstants.DEL_PRODUCT_PAGE);
		return mView;
	}

	@RequestMapping("/all/editPage/{code}")
	public ModelAndView editUserPage(@PathVariable String code) {
		Product product = service.getAProduct(code);
		ModelAndView mView = new ModelAndView();
		mView.addObject("product", product);
		mView.setViewName(MuthuConstants.EDIT_PRODUCT_PAGE);
		return mView;
	}

}
