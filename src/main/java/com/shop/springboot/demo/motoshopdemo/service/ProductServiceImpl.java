package com.shop.springboot.demo.motoshopdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.springboot.demo.motoshopdemo.dao.ProductDAO;
import com.shop.springboot.demo.motoshopdemo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	@Transactional
	public void saveUpdateProduct(Product theProduct) {
		productDao.saveUpdateProduct(theProduct);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}
	
}
