package com.va.deliveryApplication.pk.model;

public class AdminForm {
	 private String fullNamepk;
	 private String usernamepk;
	 private String passwordpk;
	 private String phonepk;
	 private String emailpk;
	 public AdminForm(String fullName,String username,String password,String phone,String email) {
		this.fullNamepk=fullName; 
		this.usernamepk=username;
		this.passwordpk=password;
		this.phonepk=phone;
		this.emailpk=email;
		}
	 public AdminForm() {
		 
	 }
	public String getFullNamepk() {
		return fullNamepk;
	}
	public void setFullNamepk(String fullName) {
		this.fullNamepk = fullName;
	}
	public String getUsernamepk() {
		return usernamepk;
	}
	public void setUsernamepk(String username) {
		this.usernamepk = username;
	}
	public String getPasswordpk() {
		return passwordpk;
	}
	public void setPasswordpk(String password) {
		this.passwordpk= password;
	}
	public String getPhonepk() {
		return phonepk;
	}
	public void setPhonepk(String phone) {
		this.phonepk = phone;
	}
	public String getEmail() {
		return emailpk;
	}
	public void setEmail(String email) {
		this.emailpk = email;
	}

}
