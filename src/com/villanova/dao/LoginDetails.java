package com.villanova.dao;

import javax.validation.constraints.Size;

import com.villanova.spring.validators.ValidEmail;
import com.villanova.spring.validators.ValidPassword;

public class LoginDetails {
	
	@ValidEmail
	private String email;
	private String passwordError;
	private String emailError;
	
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	//@Size(max=100, min=3, message="Please enter a valid name min length is 3 and max is 100")
	@ValidPassword
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDetails [email=" + email + ", password=" + password;
	}
	
	

}
