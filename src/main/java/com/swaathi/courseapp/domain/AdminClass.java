package com.swaathi.courseapp.domain;

public class AdminClass {
	
	private String adminName;
	private String adminPassword;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	@Override
	public String toString() {
		return "AdminClass [adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
}