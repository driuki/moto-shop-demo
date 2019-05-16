package com.shop.springboot.demo.motoshopdemo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.shop.springboot.demo.motoshopdemo.entity.Users;
import com.shop.springboot.demo.motoshopdemo.service.UserRegisterService;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserRegisterService userRegisterService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("Im in: " + getClass().getName());
		
		String userName = authentication.getName();
		System.out.println("USERNAME: " + userName);
		
		Users theUsers = userRegisterService.findByUserName(userName);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("user", theUsers);
		
		response.sendRedirect(request.getContextPath() + "/");
		
	}

}
