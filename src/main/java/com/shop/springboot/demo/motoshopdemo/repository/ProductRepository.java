package com.shop.springboot.demo.motoshopdemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shop.springboot.demo.motoshopdemo.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
}
