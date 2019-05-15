package com.shop.springboot.demo.motoshopdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Value("${contacts.firstname}")
	private String firstName;
	
	@Value("${contacts.lastname}")
	private String lastName;
	
	@Value("${contacts.email}")
	private String email;
	
	@Value("${contacts.number}")
	private String number;
	
	@GetMapping("/")
	public String homePage() {
		
		return "index";
		
	}
	
	@GetMapping("/contacts")
	public String contactsPage(Model theModel) {
		
		theModel.addAttribute("name", firstName);
		theModel.addAttribute("lastName", lastName);
		theModel.addAttribute("email", email);
		theModel.addAttribute("phone", number);
		
		return "contacts";
		
	}
	
}
