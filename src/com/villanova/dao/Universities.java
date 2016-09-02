package com.villanova.dao;

public class Universities {
	private String code;
	private String department;
	private String degree;
	private float gpa;
	private float workExperience;
	private boolean researchWork;
	private boolean otherCertifications;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public float getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(float workExperience) {
		this.workExperience = workExperience;
	}
	public boolean getResearchWork() {
		return researchWork;
	}
	public void setResearchWork(boolean researchWork) {
		this.researchWork = researchWork;
	}
	public boolean getOtherCertifications() {
		return otherCertifications;
	}
	public void setOtherCertifications(boolean otherCertifications) {
		this.otherCertifications = otherCertifications;
	}
	@Override
	public String toString() {
		return "Universities [code=" + code + ", department=" + department
				+ ", degree=" + degree + ", gpa=" + gpa + ", workExperience="
				+ workExperience + ", researchWork=" + researchWork
				+ ", otherCertifications=" + otherCertifications + "]";
	}
	
	
}
