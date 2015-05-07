package com.springservice.dao;

import com.springservice.bo.*;

import java.util.ArrayList;
import java.util.Iterator;

public class userdao {
	
	ArrayList<userbo> tempdata = new ArrayList<userbo>();
	
	public userdao()
	{
		userbo user1 = new userbo();
		user1.setFname("user1fname");
		user1.setLname("user1lname");
		user1.setEmail("user1email");
		user1.setAddress("user1address");
		tempdata.add(user1);
		userbo user2 = new userbo();
		user2.setFname("user2fname");
		user2.setLname("user2lname");
		user2.setEmail("user2email");
		user2.setAddress("user2address");
		tempdata.add(user2);
		userbo user3 = new userbo();
		user3.setFname("user3fname");
		user3.setLname("user3lname");
		user3.setEmail("user3email");
		user3.setAddress("user3address");
		tempdata.add(user3);
		userbo user4 = new userbo();
		user4.setFname("user4fname");
		user4.setLname("user4lname");
		user4.setEmail("user4email");
		user4.setAddress("user4address");
		tempdata.add(user4);
	}
	
	public userbo getByFname(String fname)
	{
		Iterator<userbo> iterator = tempdata.iterator();
		while(iterator.hasNext()){
		  userbo element = (userbo) iterator.next();
		  if(element.getFname().toLowerCase().equals(fname.toLowerCase()))
		  {
			  System.out.println("Found -> " + element.getFname());
			  return element;
		  }
		}
		return null;
	}
	
	public userbo getByLname(String lname)
	{
		Iterator<userbo> iterator = tempdata.iterator();
		while(iterator.hasNext()){
		  userbo element = (userbo) iterator.next();
		  if(element.getLname().toLowerCase().equals(lname.toLowerCase()))
			  return element;
		}
		return null;
	}
	
	public userbo getByEmail(String email)
	{
		Iterator<userbo> iterator = tempdata.iterator();
		while(iterator.hasNext()){
		  userbo element = (userbo) iterator.next();
		  if(element.getEmail().toLowerCase().equals(email.toLowerCase()))
			  return element;
		}
		return null;
	}
	
	public ArrayList<userbo> getAll()
	{
		return this.tempdata;
	}

}
