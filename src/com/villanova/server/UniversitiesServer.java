package com.villanova.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.villanova.dao.LoginDAO;
import com.villanova.dao.LoginDetails;
import com.villanova.dao.Universities;
import com.villanova.dao.UniversitiesDAO;
import com.villanova.dao.UserProfile;
import com.villanova.dao.UserProfileDAO;


@Service
public class UniversitiesServer {
	private UniversitiesDAO universitiesDAO;
	
	@Autowired
	public void setDetails(UniversitiesDAO universitiesDAO) {
		this.universitiesDAO = universitiesDAO;
	}

	public List<Universities> queryUniversitiesOnUserProfile(float gpa, float workExperience, String researchWork, String otherCertifications){
			return universitiesDAO.queryUniversitiesOnUserProfile(gpa, workExperience, researchWork.equals("None")?false:true, otherCertifications.equals("None")?false:true);
	}
	
}
