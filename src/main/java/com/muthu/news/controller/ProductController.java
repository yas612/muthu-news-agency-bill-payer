package com.muthu.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.muthu.news.Product;
import com.muthu.news.exception.CustomException;
import com.muthu.news.service.ProductService;

@RestController
@RequestMapping("/admin/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/all")
	public ModelAndView productPage() throws CustomException {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("products");
		List<Product> productlist = service.getAll();
		if(productlist == null) {
			mView.addObject("errorMsg", "ERROR occured while fetching Product details");
			return mView;
		}
		else {
		mView.addObject("productlist", productlist);
		return mView;
		}
	}
	
	@RequestMapping("/all/addproductPage")
	public ModelAndView addUserPage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("add-product");
		return mView;
	}
	
	@RequestMapping("/all/addProduct")
	public ModelAndView addProduct(@RequestParam("code") String code, @RequestParam("name") String name,
			@RequestParam("price") Double price) {
		Product product = new Product();
		product.setCode(code);
		product.setName(name);
		product.setPrice(price);
		Product verifier = service.addProduct(product);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("add-product");
		if(verifier==null) {
			mView.addObject("msg", "ERROR occurred while adding Product with details : "+product.toString());
		}
		else {
			mView.addObject("msg", "SUCCESSFULLY added product with details : "+product.toString());
			mView.addObject("product", product);
		}
		return mView;
	}
	
	@RequestMapping("/all/editPage/editProduct")
	public ModelAndView editProduct(@RequestParam("code") String code, @RequestParam("name") String name,
			@RequestParam("price") Double price) throws CustomException {
		Product product = new Product();
		product.setCode(code);
		product.setName(name);
		product.setPrice(price);
		Product verifier = service.updateProduct(product);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("edit-product");
		if(verifier==null) {
			mView.addObject("msg", "ERROR occurred while updating Product with details : "+product.toString());
		}
		else {
			mView.addObject("msg", "SUCCESSFULLY updated product with details : "+product.toString());
			mView.addObject("product", product);
		}
		return mView;
		
	}
	
	@RequestMapping("/all/delPage/delProduct")
	public ModelAndView delProduct(@RequestParam String code) throws CustomException {
		Boolean decider = service.remProduct(code);
		ModelAndView mView = new ModelAndView();
		if(decider) {
			mView.addObject("msg", "<p>User deletion action for user : "+code+" is SUCCESS</p>");
		}
		else {
			mView.addObject("msg", "<p>User deletion action for user : "+code+" is FAILED</p>");
		}
		mView.setViewName("delete-product");
		return mView;
	}
	
	@RequestMapping("/all/delPage/{code}")
	public ModelAndView delProductPage(@PathVariable String code) {
		Product product = service.getAProduct(code);
		ModelAndView mView = new ModelAndView();
		mView.addObject("code", product.getCode());
		mView.setViewName("delete-product");
		return mView;
	}
	
	@RequestMapping("/all/editPage/{code}")
	public ModelAndView editUserPage(@PathVariable String code) {
		Product product = service.getAProduct(code);
		ModelAndView mView = new ModelAndView();
		mView.addObject("product", product);
			mView.setViewName("edit-product");
			return mView;
	}

}
