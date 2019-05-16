package com.shop.springboot.demo.motoshopdemo.dao;

import com.shop.springboot.demo.motoshopdemo.entity.Role;

public interface RoleDAO {
	
	public Role findRoleByName(String theRoleName);
	
}
