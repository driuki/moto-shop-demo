package com.shop.springboot.demo.motoshopdemo.dao;

import com.shop.springboot.demo.motoshopdemo.entity.Users;

public interface UserRegisterDAO {
	
	Users findByUserName(String userName);
	
	void save(Users users);

}
