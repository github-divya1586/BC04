package com.model;

import java.util.Comparator;

public class RegisterModel {
	
	int userid;
	String name;
	String emailid;
	String password;
	String mobile;
	
	
	
	public RegisterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterModel(int userid, String name, String emailid, String password, String mobile) {
		super();
		this.userid = userid;
		this.name = name;
		this.emailid = emailid;
		this.password = password;
		this.mobile = mobile;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	

}



