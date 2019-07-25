package com.shop.springboot.demo.motoshopdemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shop.springboot.demo.motoshopdemo.entity.Users;
import com.shop.springboot.demo.motoshopdemo.user.CrmUserRegister;

public interface UserRepository extends PagingAndSortingRepository<Users, Integer> {
	
	Users findByUsername(String username);

	Users save(CrmUserRegister theCrmUserRegister);
	
}
