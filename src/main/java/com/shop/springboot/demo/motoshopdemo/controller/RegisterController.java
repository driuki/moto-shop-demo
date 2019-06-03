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
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.springboot.demo.motoshopdemo.entity.Users;
import com.shop.springboot.demo.motoshopdemo.repository.UserRepository;
import com.shop.springboot.demo.motoshopdemo.user.CrmUserRegister;

@Controller
public class RegisterController {
	
//	private UserRepository userRepository;
//	
//	public RegisterController(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/register")
	public String registerForm() {
		
		return "register";
		
	}
	
//	@PostMapping("/register")
//	public String postRegisterForm(@Valid @ModelAttribute("crmUser") CrmUserRegister theCrmUserRegister, 
//									BindingResult theBindingResult, 
//									Model theModel) {
//		
//		String username = theCrmUserRegister.getUsername();
//		
//		Users user = userRepository.findByUsername(username);
//		
//		if (theBindingResult.hasErrors()) {
//			return "register?error";
//		}
//		
//		if (user != null) {
//			
//			theModel.addAttribute("crmUser", new CrmUserRegister());
//			theModel.addAttribute("registrationError", "User name already exists.");
//			
//			return "/register?exists";
//		}
//		
//		
//		
//		
//		
//		return "redirect:/";
//		
//	}
	
}

//@RequestParam String username, 
//@RequestParam String password,
//@RequestParam String firstname,
//@RequestParam String lastname,
//@RequestParam String email,
//@RequestParam String address