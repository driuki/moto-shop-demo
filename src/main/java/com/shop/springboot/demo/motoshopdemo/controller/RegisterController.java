package com.shop.springboot.demo.motoshopdemo.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.springboot.demo.motoshopdemo.entity.Users;
import com.shop.springboot.demo.motoshopdemo.service.UserRegisterService;
import com.shop.springboot.demo.motoshopdemo.user.CrmUserRegister;

@Controller
public class RegisterController {
	
	private UserRegisterService userRegisterService;
	
	@Autowired
	public RegisterController(UserRegisterService userRegisterService) {
		this.userRegisterService = userRegisterService;
	}
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/register")
	public String registerForm(Model theModel) {
		
		logger.info(" \n\nIn registration page " + getClass().getSimpleName() + "\n\n");
		
		theModel.addAttribute("crmUserRegister", new CrmUserRegister());
		
		return "register";
		
	}
	
	@PostMapping("/register")
	public String postRegisterForm(@Valid @ModelAttribute("crmUser") CrmUserRegister theCrmUserRegister, 
									BindingResult theBindingResult, 
									Model theModel) {
		
		String username = theCrmUserRegister.getUsername();
		
		Users user = userRegisterService.findByUserName(username);
		
//		if (theBindingResult.hasErrors()) {
//			logger.warning("Has errors");
//			return "register";
//		}
		
		if (user != null) {
			
			logger.warning("User exists " + user);
			
			theModel.addAttribute("crmUserRegister", new CrmUserRegister());
			theModel.addAttribute("registrationError", "User name already exists.");
			
			return "register";
		}
		
		userRegisterService.save(theCrmUserRegister);
		
		logger.info("Succesfully created user: " + username);
		
		return "redirect:/";
		
	}
	
}
