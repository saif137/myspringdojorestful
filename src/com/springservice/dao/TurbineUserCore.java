package com.springservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.UserException;

import com.springservice.bo.*;

class Check
{
	static boolean isEmpty(String str)
	{
			if(str.equals(""))
				return true;			
			return false;
	}
	static boolean isEmpty(int id)
	{
			if(id == 0)
				return true;			
			return false;
	}
}

public class TurbineUserCore {
	
	static ArrayList<TurbineUser> tempdata = new ArrayList<TurbineUser>();
	
	public static void Init()
	{
		TurbineUser tu1 = new TurbineUser();
		tu1.setLoginName("loginname1");
		tu1.setEmail("email1");
		tempdata.add(tu1);

		TurbineUser tu2 = new TurbineUser();
		tu2.setLoginName("loginname2");
		tu2.setEmail("email2");
		tempdata.add(tu2);

		TurbineUser tu3 = new TurbineUser();
		tu3.setLoginName("loginname3");
		tu3.setEmail("email3");
		tempdata.add(tu3);

		TurbineUser tu4 = new TurbineUser();
		tu4.setLoginName("loginname4");
		tu4.setEmail("email4");
		tempdata.add(tu4);

		TurbineUser tu5 = new TurbineUser();
		tu5.setLoginName("loginname5");
		tu5.setEmail("email5");
		tempdata.add(tu5);

	}
	
	public static TurbineUser getTurbineUserByLoginName( String userName )
	/*throws UserException*/
	{
		if(Check.isEmpty(userName))
			return null;
		
		/*
		TurbineUser user = null;
		Criteria criteria = new Criteria();
		Integer[] excludedUserIds = {2,33,21,22,23};
		if(!Check.isEmpty(excludedUserIds))
		
		criteria.addNotIn(TurbineUserPeer.USER_ID, excludedUserIds);
		criteria.add(TurbineUserPeer.LOGIN_NAME, userName);
		
		List<TurbineUser> users;
		
		try
		{
		    users = TurbineUserPeer.doSelect(criteria);
		 		
		}
		catch(Exception e)
		{
		    throw new UserException(
		        "Failed to check account's presence", e);
		}
		if (users.size() == 1)
		{
		    user =  users.get(0);
		}
		else if (users.size() >1)
		{
		    throw new UserException(
			        "There are more than one user with login name of " + userName );
		}
		return users;
		*/
		Iterator<TurbineUser> iterator = tempdata.iterator();
		while(iterator.hasNext()){
		  TurbineUser element = (TurbineUser) iterator.next();
		  if(element.getLoginName().toLowerCase().equals(userName.toLowerCase()))
		  {
			  System.out.println("Found -> " + element.getLoginName());
			  return element;
		  }
		}
		return null;
	}
	
	public static TurbineUser getTurbineUserByEmail( String email )
			/*throws UserException*/
			{
				if(Check.isEmpty(email))
					return null;
				
				/*
				TurbineUser user = null;
				Criteria criteria = new Criteria();
				Integer[] excludedUserIds = {2,33,21,22,23};
				if(!Check.isEmpty(excludedUserIds))
				
				criteria.addNotIn(TurbineUserPeer.USER_ID, excludedUserIds);
				criteria.add(TurbineUserPeer.EMAIL, email);
				
				List<TurbineUser> users;
				
				try
				{
				    users = TurbineUserPeer.doSelect(criteria);
				 		
				}
				catch(Exception e)
				{
				    throw new UserException(
				        "Failed to check account's presence", e);
				}
				if (users.size() == 1)
				{
				    user =  users.get(0);
				}
				else if (users.size() >1)
				{
				    throw new UserException(
					        "There are more than one user with login name of " + email );
				}
				return users;
				*/
				Iterator<TurbineUser> iterator = tempdata.iterator();
				while(iterator.hasNext()){
				  TurbineUser element = (TurbineUser) iterator.next();
				  if(element.getEmail().toLowerCase().equals(email.toLowerCase()))
				  {
					  System.out.println("Found -> " + element.getEmail());
					  return element;
				  }
				}
				return null;
			}
	
	//This function is used internally normally. It referes to the primary key of the data
	/*
	public static TurbineUser getTurbineUserById( int id )
			throws UserException
			{
				if(Check.isEmpty(id))
					return null;
				
				TurbineUser user = null;
				Criteria criteria = new Criteria();
				Integer[] excludedUserIds = {2,33,21,22,23};
				if(!Check.isEmpty(excludedUserIds))
				
				criteria.addNotIn(TurbineUserPeer.USER_ID, excludedUserIds);
				criteria.add(TurbineUserPeer.LOGIN_NAME, id);
				
				List<TurbineUser> users;
				
				try
				{
				    users = TurbineUserPeer.doSelect(criteria);
				 		
				}
				catch(Exception e)
				{
				    throw new UserException(
				        "Failed to check account's presence", e);
				}
				if (users.size() == 1)
				{
				    user =  users.get(0);
				}
				else if (users.size() >1)
				{
				    throw new UserException(
					        "There are more than one user with login name of " + id );
				}
				return user;
			}
			*/
	
public static List<TurbineUser> getUsers() /*throws Exception*/ {
	
	/*
		List<TurbineUser> users = null;
		Criteria c = new Criteria();
		Integer[] excludedUserIds = {2,33,21,22,23};
		if(!Check.isEmpty(excludedUserIds))
		c.addNotIn(TurbineUserPeer.USER_ID, excludedUserIds);
		c.addAscendingOrderByColumn(TurbineUserPeer.LOGIN_NAME);
		users = TurbineUserPeer.doSelect(c);
		if (users == null) 
			users = new ArrayList<TurbineUser>();
		return users;
			*/
	return tempdata;
	}
}