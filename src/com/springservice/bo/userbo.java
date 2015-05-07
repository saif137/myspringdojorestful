package com.springservice.bo;

public class userbo {
	private String fname;
	private String lname;
	private String email;
	private String address;
	public userbo(){
		this.fname = "";
		this.lname = "";
		this.email = "";
		this.address = "";
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
}