package com.shop.springboot.demo.motoshopdemo.repository;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.shop.springboot.demo.motoshopdemo.entity.Users;
import com.shop.springboot.demo.motoshopdemo.user.CrmUserRegister;

public interface UserRepository extends UserDetailsService {
	
	Users findByUsername(String username);
	
	void save(CrmUserRegister crmUser);
	
}
