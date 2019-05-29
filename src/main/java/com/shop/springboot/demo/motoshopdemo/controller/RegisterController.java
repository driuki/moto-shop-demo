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
import com.shop.springboot.demo.motoshopdemo.user.CrmUserRegister;

@Controller
public class RegisterController {
	
//	ERROR
//	Error creating bean with name 'registerController': Unsatisfied dependency expressed through field 'userRegisterService';
//	@Autowired
//	private UserRegisterService userRegisterService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@GetMapping("/register")
	public String registerForm(Model theModel) {
		
		theModel.addAttribute("crmUser", new CrmUserRegister());
		
		return "register";
		
	}
	
//	@PostMapping("/processRegister")
//	public String registerPost(@Valid @ModelAttribute("crmUser") CrmUserRegister theCrmUserRegister,
//									BindingResult theBindingResult, Model theModel) {
//		
//		String user = theCrmUserRegister.getUsername();
//		logger.info("Registration of user: " + user);
//		
//		if (theBindingResult.hasErrors()) {
//			return "register";
//		}
//		
//		Users isExisting = userRegisterService.findByUserName(user);
//		
//		if (isExisting != null) {
//			theModel.addAttribute("crmUser", new CrmUserRegister());
//			theModel.addAttribute("registrationError", "User already exists");
//			
//			logger.warning("User already exists");
//			return "register";
//		}
//		
//		userRegisterService.save(theCrmUserRegister);
//		
//		logger.info("Successfully created user" + user);
//		
//		return "/";
//		
//	}
	
}
