package com.shop.springboot.demo.motoshopdemo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.springboot.demo.motoshopdemo.dao.RoleDAO;
import com.shop.springboot.demo.motoshopdemo.dao.UserRegisterDAO;
import com.shop.springboot.demo.motoshopdemo.entity.Role;
import com.shop.springboot.demo.motoshopdemo.entity.Users;
import com.shop.springboot.demo.motoshopdemo.user.CrmUserRegister;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
	
//	@Autowired
	private RoleDAO roleDao;
	
//	@Autowired
	private UserRegisterDAO userRegisterDAO;
	
//	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	ERROR
//	nested exception: Unsatisfied dependency expressed through constructor parameter 0;
//	No qualifying bean of type 'org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
	@Autowired
	public UserRegisterServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, RoleDAO roleDao, UserRegisterDAO userRegisterDAO) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.roleDao = roleDao;
		this.userRegisterDAO = userRegisterDAO;
	}
	
	@Override
	@Transactional
	public Users findByUserName(String userName) {
		return userRegisterDAO.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUserRegister crmUser) {
		Users users = new Users();
		users.setUsername(crmUser.getUsername());
		users.setPassword(bCryptPasswordEncoder.encode(crmUser.getPassword()));
		users.setFirstName(crmUser.getFirstName());
		users.setLastName(crmUser.getLastName());
		users.setEmail(crmUser.getEmail());
		users.setAddress(crmUser.getAddress());
		
		users.setRoles(Arrays.asList(roleDao.findRoleByName("customer")));
		
		userRegisterDAO.save(users);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRegisterDAO.findByUserName(username);
		if (users == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), 
					mapRolesToAuthorities(users.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
	
}
