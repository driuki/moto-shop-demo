package com.shop.springboot.demo.motoshopdemo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.shop.springboot.demo.motoshopdemo.validation.FieldMatch;
import com.shop.springboot.demo.motoshopdemo.validation.ValidEmail;

@FieldMatch.List({
	@FieldMatch(first = "password", second = "matchingPassword", message = "Password field must match ☺")
})
public class CrmUserRegister {
	
	@NotNull(message = "Required")
	@Size(min = 4, message = "Min symbols number - 4")
	private String username;
	
	@NotNull(message = "Required")
	@Size(min = 6, message = "Min symbols count is 6")
	private String password;
	
	@NotNull(message = "Required")
	@Size(min = 6, message = "Min symbols count is 6")
	private String matchingPassword;
	
	@NotNull(message = "Required")
	@Size(min = 2, message = "Min symbols number - 2")
	private String firstName;
	
	@NotNull(message = "Required")
	@Size(min = 2, message = "Min symbols number - 2")
	private String lastName;
	
	@ValidEmail
	@NotNull(message = "Required")
	@Size(min = 5, message = "Required")
	private String email;
	
	@NotNull(message = "Required")
	@Size(min = 2, message = "Required")
	private String address;
	
	public CrmUserRegister() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
