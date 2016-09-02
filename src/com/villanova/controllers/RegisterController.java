package com.villanova.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;







//import com.sun.javafx.collections.MappingChange.Map;
import com.villanova.dao.LoginDetails;
import com.villanova.dao.RegisterDetails;
import com.villanova.dao.UserProfile;
import com.villanova.server.Server;
import com.villanova.server.UserProfileServer;

@Controller
public class RegisterController {
	
	@Autowired
	private Server server;
	@Autowired
	private UserProfileServer userProfileServer;
	
	@RequestMapping("/register")
	public String myRegistration(Model model) {
		//model.addAttribute("detail", new LoginDetails());
		
		Map<String,Object> modelMap = (Map<String, Object>) model.asMap();
		if(((Map<String, Object>) modelMap).get("registerDetail")==null)
			model.addAttribute("registerDetail", new RegisterDetails());
		return "register";
	}
	
	@RequestMapping("/RegisterUser")
	public String registerDetail(Model model, @ModelAttribute("registerDetail") @Valid RegisterDetails details, BindingResult result) {
		
		//System.out.println("Shameless");
		if(result.hasErrors())
		{	//System.out.println("Shame");	
			for(ObjectError error : result.getAllErrors())
			{
				System.out.println(error.getDefaultMessage());
			}
			model.addAttribute("registerDetail", details);
			//return "home";
			return myRegistration(model);
		}
		Map<String,Object> modelMap = (Map<String, Object>) model.asMap();	
		RegisterDetails detail = (RegisterDetails) ((Map<String, Object>) modelMap).get("registerDetail");
		
		String email=detail.getEmail();
		String password=detail.getPassword();
		String confirmPassword=detail.getConfirmPassword();
		
		if(server.getAllEmails().contains(email))
		{
			details.setEmailError("Email Address Already Contains");
			model.addAttribute("detail", details);
			return myRegistration(model);
		}
		
		if(!password.equals(confirmPassword))
		{
			details.setConfirmPasswordError("Password Mismatch, Please enter the password again");
			model.addAttribute("detail", details);
			return myRegistration(model);
		}

		LoginDetails loginDetails=new LoginDetails();
		loginDetails.setEmail(email);
		loginDetails.setPassword(password);
		server.create(loginDetails);
		System.out.println(userProfileServer);
		if(((Map<String, Object>) modelMap).get("userProfile")==null)
			model.addAttribute("userProfile", new UserProfile());	
		return new UserProfileController(userProfileServer).home(model);
	}

}
