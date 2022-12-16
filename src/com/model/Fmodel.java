package com.model;

public class Fmodel extends RegisterModel{
	
	private String address;
	private String mobile;
	private String signature;
	private String publicKey;
	
	
	
	public Fmodel(int userid, String name, String emailid, String password, String mobile) {
		super(userid, name, emailid, password, mobile);
		// TODO Auto-generated constructor stub
	}
	public Fmodel(int userid, String name, String emailid, String password, String mobile, String address,
			String mobile2, String signature, String publicKey) {
		super(userid, name, emailid, password, mobile);
		this.address = address;
		mobile = mobile2;
		this.signature = signature;
		this.publicKey = publicKey;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	
	
	

}
