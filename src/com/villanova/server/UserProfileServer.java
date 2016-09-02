package com.villanova.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.villanova.dao.LoginDAO;
import com.villanova.dao.LoginDetails;
import com.villanova.dao.UserProfile;
import com.villanova.dao.UserProfileDAO;


@Service
public class UserProfileServer {
	private UserProfileDAO userProfileDAO;
	
	@Autowired
	public void setDetails(UserProfileDAO userProfileDAO) {
		this.userProfileDAO = userProfileDAO;
	}

	public boolean create(UserProfile details)
	{
		return userProfileDAO.create(details);
	}
	
	public boolean update(UserProfile details)
	{
		return userProfileDAO.update(details);
	}
	public List<UserProfile> getAll()
	{
		return userProfileDAO.getAll();
	}
	
	public UserProfile getUserProfileByEmail(String email)
	{
		return userProfileDAO.getUserProfileByEmail(email);
	}
	
//	public void throwDataAccessException() {
//		// TODO Auto-generated method stub
//		offersDao.getOfferById(999999);
//	}

}
