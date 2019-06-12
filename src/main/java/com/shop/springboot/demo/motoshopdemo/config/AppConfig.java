package com.shop.springboot.demo.motoshopdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.shop.springboot.demo.motoshopdemo.dao.UserRegisterDAO;
import com.shop.springboot.demo.motoshopdemo.entity.Users;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.shop.springboot.demo.motoshopdemo")
public class AppConfig {
	
    @Bean
    public UserRegisterDAO userRegisterDAO() {
        return new UserRegisterDAO() {
			
			@Override
			public void save(Users users) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Users findByUserName(String userName) {
				// TODO Auto-generated method stub
				return null;
			}
		};
    }
    
    @Bean
    public BCryptPasswordEncoder passswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
	
}