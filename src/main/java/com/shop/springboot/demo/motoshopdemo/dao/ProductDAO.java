package com.shop.springboot.demo.motoshopdemo.dao;

import java.util.List;

import com.shop.springboot.demo.motoshopdemo.entity.Product;

public interface ProductDAO {
	
	public List<Product> getProducts();
	
	public Product getProductById(int id);
	
	public void saveUpdateProduct(Product theProduct);
	
	public void deleteProduct(int id);	
}
