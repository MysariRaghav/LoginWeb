package com.villanova.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;













//import com.sun.javafx.collections.MappingChange.Map;
import com.villanova.dao.LoginDetails;
import com.villanova.dao.RegisterDetails;
import com.villanova.dao.Universities;
import com.villanova.dao.UserProfile;
import com.villanova.server.Server;
import com.villanova.server.UniversitiesServer;
import com.villanova.server.UserProfileServer;

@Controller
public class UserProfileController {
	
//	@Autowired
//	private Server server;
	
	@Autowired
	private UserProfileServer userProfileServer;
	@Autowired
	private UniversitiesServer universitiesServer;
	public UserProfileController(){}
	
	public UserProfileController(UserProfileServer userProfileServer){
		this.userProfileServer=userProfileServer;
	}
	
	@RequestMapping("/UserProfile")
	public String home(Model model) {
		Map<String,Object> modelMap = (Map<String, Object>) model.asMap();
		Object detail = ((Map<String, Object>) modelMap).get("detail");
		
		UserProfile userProfile;
		
		if(modelMap.get("userProfile")!=null)
		{
			userProfile=(UserProfile) modelMap.get("userProfile");
		}
		else
		{
			userProfile =new UserProfile();
		}
		System.out.println(userProfileServer);
		
		UserProfile profile;
		
		if(detail==null)
			profile=new UserProfile();
		else if(detail instanceof LoginDetails)
			try{
			profile=userProfileServer.getUserProfileByEmail(((LoginDetails)detail).getEmail());
			}
			catch(EmptyResultDataAccessException e)
			{
				profile=new UserProfile();
				profile.setEmail(((LoginDetails)detail).getEmail());
			}
		else if(detail instanceof RegisterDetails)
			profile=userProfileServer.getUserProfileByEmail(((RegisterDetails)detail).getEmail());
		else
			profile=new UserProfile();
		model.addAttribute("userProfile", profile);	
		
		return "userProfile";
	}
	
	@RequestMapping("/feedUserProfile")
	public String registerController(Model model, @ModelAttribute("userProfile") @Valid UserProfile userProfile, BindingResult result) {				
		
		UserProfile profileAlreadyInDB;
		if(result.hasErrors())
		{
			for(ObjectError error : result.getAllErrors())
			{
				System.out.println(error.getDefaultMessage());
			}
			//model.addAttribute("registerDetail", userProfile);
			return "userProfile";
		}
//		Map<String,Object> modelMap = (Map<String, Object>) model.asMap();	
//		UserProfile userProfile = (UserProfile) ((Map<String, Object>) modelMap).get("userProfile");
		
		System.out.println(userProfile);
		
		profileAlreadyInDB = userProfileServer.getUserProfileByEmail(userProfile.getEmail());
		
		if(profileAlreadyInDB== null)
			userProfileServer.create(userProfile);
		else if(!profileAlreadyInDB.equals(userProfile))
			userProfileServer.update(userProfile);
		

		
		
		
		for(UserProfile profile:userProfileServer.getAll())
		{
			System.out.println("********************************************************************************");
			System.out.println(profile);
		}
		
		//if(((Map<String, Object>) modelMap).get("userProfile")==null)
		model.addAttribute("userProfile", userProfile);	
		
		
		// Adding to eligible Universities to model for displaying in jsp pages
		List<Universities> universities= universitiesServer.queryUniversitiesOnUserProfile(userProfile.getGpa(), userProfile.getWorkExperience(), userProfile.getResearchWork(), userProfile.getOtherCertifications());
		model.addAttribute("universities", universities);
		return "yourUniversities";
	}

}
