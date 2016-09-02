package com.villanova.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.villanova.dao.LoginDAO;
import com.villanova.dao.LoginDetails;


@Service
public class Server {
	private LoginDAO loginDAO;
	
	@Autowired
	public void setDetails(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public boolean create(LoginDetails details)
	{
		return loginDAO.create(details);
	}
	
	public List<LoginDetails> getAll()
	{
		return loginDAO.getAll();
	}
	
	public LoginDetails getPasswordByEmail(String email)
	{
		return loginDAO.getPasswordByEmail(email);
	}

	public List<String> getAllEmails() {
		// TODO Auto-generated method stub
		return loginDAO.getAllEmails();
	}


//	public void throwDataAccessException() {
//		// TODO Auto-generated method stub
//		offersDao.getOfferById(999999);
//	}

}
