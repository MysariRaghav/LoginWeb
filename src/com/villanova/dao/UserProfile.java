package com.villanova.dao;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.villanova.spring.validators.ValidEmail;
import com.villanova.spring.validators.ValidPassword;

public class UserProfile {
	
	@ValidEmail
	private String email;
	@Size(min=2, max=60, message="Incorrect size, Please enter name in range 2-60")
	private String firstName;
	@Size(min=2, max=60, message="Incorrect size, Please enter name in range 2-60")
	private String lastName;
	@Size(min=10, max=20, message="Incorrect size, Please enter phone in range 10-20")
	private String phone;
	@Size(min=0, max=100, message="Incorrect size, Please enter country in range 2-100")
	private String country;
	@Size(min=2, max=45, message="Incorrect size, Please enter major in range 2-45")
	private String highestMajor;
	@Size(min=2, max=45, message="Incorrect size, Please enter major in range 2-45")
	private String areaOfInterest;
	@Size(min=0, max=45, message="Incorrect size, Please enter major in range 2-45")
	private String currentUniversity;
	//@Size(min=1, max=5, message="Incorrect size, Please enter gpa")
	@DecimalMax(value="4", message="Please enter gpa on 4 scale")
	private float gpa;
	//@Size(min=1, max=5, message="Incorrect size, Please enter No of Backlogs")
	@Digits(fraction = 0, integer = 3)
	private int numberOfBacklogs;
	//@Size(min=1, max=5, message="Incorrect size, Please enter No of Years Work Experience")
	@DecimalMax(value="100", message="Please enter valid work experience")
	private float workExperience;
	@Size(min=0, max=500, message="Incorrect size, Please enter in range 0-500")
	private String researchWork;
	@Size(min=0, max=300, message="Incorrect size, Please enter in range 0-300")
	private String otherCertifications;
	
	// Used for displaying in JSP pages
	private String emailChanged;
	private String firstNameChanged;
	private String lastNameChanged;
	private String phoneChanged;
	private String countryChanged;
	private String highestMajorChanged;
	private String areaOfInterestChanged;
	private String currentUniversityChanged;
	private String gpaChanged;
	private String numberOfBacklogsChanged;
	private String workExperienceChanged;
	private String researchWorkChanged;
	private String otherCertificationsChanged;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "UserProfile [email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", country="
				+ country + ", highestMajor=" + highestMajor
				+ ", areaOfInterest=" + areaOfInterest + ", currentUniversity="
				+ currentUniversity + ", gpa=" + gpa + ", numberOfBacklogs="
				+ numberOfBacklogs + ", workExperience=" + workExperience
				+ ", researchWork=" + researchWork + ", otherCertifications="
				+ otherCertifications + ", emailChanged=" + emailChanged
				+ ", firstNameChanged=" + firstNameChanged + ", lastNameChanged="
				+ lastNameChanged + ", phoneChanged=" + phoneChanged
				+ ", countryChanged=" + countryChanged + ", highestMajorChanged="
				+ highestMajorChanged + ", areaOfInterestChanged="
				+ areaOfInterestChanged + ", currentUniversityChanged="
				+ currentUniversityChanged + ", gpaChanged=" + gpaChanged
				+ ", numberOfBacklogsChanged=" + numberOfBacklogsChanged
				+ ", workExperienceChanged=" + workExperienceChanged
				+ ", researchWorkChanged=" + researchWorkChanged
				+ ", otherCertificationsChanged=" + otherCertificationsChanged
				+ "]";
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHighestMajor() {
		return highestMajor;
	}
	public void setHighestMajor(String highestMajor) {
		this.highestMajor = highestMajor;
	}
	public String getAreaOfInterest() {
		return areaOfInterest;
	}
	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}
	public String getCurrentUniversity() {
		return currentUniversity;
	}
	public void setCurrentUniversity(String currentUniversity) {
		this.currentUniversity = currentUniversity;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public int getNumberOfBacklogs() {
		return numberOfBacklogs;
	}
	public void setNumberOfBacklogs(int numberOfBacklogs) {
		this.numberOfBacklogs = numberOfBacklogs;
	}
	public float getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(float workExperience) {
		this.workExperience = workExperience;
	}
	public String getResearchWork() {
		return researchWork;
	}
	public void setResearchWork(String researchWork) {
		this.researchWork = researchWork;
	}
	public String getOtherCertifications() {
		return otherCertifications;
	}
	public void setOtherCertifications(String otherCertifications) {
		this.otherCertifications = otherCertifications;
	}
	public String getEmailChanged() {
		return emailChanged;
	}
	public void setEmailChanged(String emailChanged) {
		this.emailChanged = emailChanged;
	}
	public String getFirstNameChanged() {
		return firstNameChanged;
	}
	public void setFirstNameChanged(String firstNameChanged) {
		this.firstNameChanged = firstNameChanged;
	}
	public String getLastNameChanged() {
		return lastNameChanged;
	}
	public void setLastNameChanged(String lastNameChanged) {
		this.lastNameChanged = lastNameChanged;
	}
	public String getPhoneChanged() {
		return phoneChanged;
	}
	public void setPhoneChanged(String phoneChanged) {
		this.phoneChanged = phoneChanged;
	}
	public String getCountryChanged() {
		return countryChanged;
	}
	public void setCountryChanged(String countryChanged) {
		this.countryChanged = countryChanged;
	}
	public String getHighestMajorChanged() {
		return highestMajorChanged;
	}
	public void setHighestMajorChanged(String highestMajorChanged) {
		this.highestMajorChanged = highestMajorChanged;
	}
	public String getAreaOfInterestChanged() {
		return areaOfInterestChanged;
	}
	public void setAreaOfInterestChanged(String areaOfInterestChanged) {
		this.areaOfInterestChanged = areaOfInterestChanged;
	}
	public String getCurrentUniversityChanged() {
		return currentUniversityChanged;
	}
	public void setCurrentUniversityChanged(String currentUniversityChanged) {
		this.currentUniversityChanged = currentUniversityChanged;
	}
	public String getGpaChanged() {
		return gpaChanged;
	}
	public void setGpaChanged(String gpaChanged) {
		this.gpaChanged = gpaChanged;
	}
	public String getNumberOfBacklogsChanged() {
		return numberOfBacklogsChanged;
	}
	public void setNumberOfBacklogsChanged(String numberOfBacklogsChanged) {
		this.numberOfBacklogsChanged = numberOfBacklogsChanged;
	}
	public String getWorkExperienceChanged() {
		return workExperienceChanged;
	}
	public void setWorkExperienceChanged(String workExperienceChanged) {
		this.workExperienceChanged = workExperienceChanged;
	}
	public String getResearchWorkChanged() {
		return researchWorkChanged;
	}
	public void setResearchWorkChanged(String researchWorkChanged) {
		this.researchWorkChanged = researchWorkChanged;
	}
	public String getOtherCertificationsChanged() {
		return otherCertificationsChanged;
	}
	public void setOtherCertificationsChanged(String otherCertificationsChanged) {
		this.otherCertificationsChanged = otherCertificationsChanged;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		UserProfile user = (UserProfile)obj;
		if(firstName.equals(user.firstName) &&
				lastName.equals(user.lastName) &&
				phone.equals(user.phone) &&
				email.equals(user.email) &&
				country.equals(user.country) &&
				highestMajor.equals(user.highestMajor) &&
				areaOfInterest.equals(user.areaOfInterest) && 
				currentUniversity.equals(user.currentUniversity) &&
				gpa == user.gpa &&
				numberOfBacklogs == user.numberOfBacklogs && 
				workExperience == user.workExperience && 
				researchWork.equals(user.researchWork) && 
				otherCertifications.equals(user.otherCertifications))
			return true;
		
		return false;
	}
	
	
	
	
	

}
