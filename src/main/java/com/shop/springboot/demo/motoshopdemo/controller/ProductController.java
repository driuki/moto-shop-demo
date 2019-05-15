package com.shop.springboot.demo.motoshopdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.springboot.demo.motoshopdemo.entity.Product;
import com.shop.springboot.demo.motoshopdemo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String getProducts(Model theModel) {
		
		List<Product> listOfProducts = productService.getProducts();
		
		theModel.addAttribute("products", listOfProducts);
		
		return "products";
	}
	
	@GetMapping("{id}")
	public String getOneProduct(@PathVariable int id, Model theModel) {
		
		Product product = productService.getProductById(id);
		
		theModel.addAttribute("product", product);
		
		return "one-product";
		
	}
	
}
