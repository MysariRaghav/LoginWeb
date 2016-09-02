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
import com.villanova.dao.Universities;
import com.villanova.dao.UniversitiesDAO;
import com.villanova.dao.UserProfile;
import com.villanova.server.Server;
import com.villanova.server.UserProfileServer;

@Controller
public class LoginController {
	
	@Autowired
	private Server server;
	@Autowired
	private UserProfileServer userProfileServer;
	@Autowired
	private UniversitiesDAO univDAO;
	
	@RequestMapping("/")
	public String home(Model model) {
		//tjfgf
		//Test Code to test univDAO.queryUniversitiesOnUserProfile
		/*for(Universities univ: univDAO.queryUniversitiesOnUserProfile(3.4f, 0, false, false))
		System.out.println(univ);*/	
		
		Map<String,Object> modelMap = (Map<String, Object>) model.asMap();
		if(((Map<String, Object>) modelMap).get("detail")==null)
			model.addAttribute("detail", new LoginDetails());		
		return "home";
	}
	
	@RequestMapping("/Login")
	public String login(Model model, @ModelAttribute("detail") @Valid LoginDetails details, BindingResult result) {
		
		if(result.hasErrors())
		{	
			for(ObjectError error : result.getAllErrors())
			{
				System.out.println(error.getDefaultMessage());
			}
			model.addAttribute("detail", details);
			//return "home";
			return home(model);
		}
		
		Map<String,Object> modelMap = (Map<String, Object>) model.asMap();	
		LoginDetails detail = (LoginDetails) ((Map<String, Object>) modelMap).get("detail");
		
		String email=detail.getEmail();
		String password=detail.getPassword();
		
		if(!server.getAllEmails().contains(email))
		{
			details.setEmailError("Worng Email Address");
			model.addAttribute("detail", details);
			return home(model);
		}
		
		if(!password.equals(server.getPasswordByEmail(email).getPassword()))
		{
			details.setPasswordError("Worng Password");
			model.addAttribute("detail", details);
			return home(model);
		}				
		if(((Map<String, Object>) modelMap).get("userProfile")==null)
			model.addAttribute("userProfile", new UserProfile());	
		return new UserProfileController(userProfileServer).home(model);
	}
}