package com.springservice.dao;

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
	
	public static TurbineUser getTurbineUserByLoginName( String userName )
	throws UserException
	{
		if(Check.isEmpty(userName))
			return null;
		
		TurbineUser user = null;
		/*
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
		*/
		return user;
	}
	
	public static TurbineUser getTurbineUserByEmail( String email )
			throws UserException
			{
				if(Check.isEmpty(email))
					return null;
				
				TurbineUser user = null;
				/*
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
				*/
				return user;
			}
	
	public static TurbineUser getTurbineUserById( int id )
			throws UserException
			{
				if(Check.isEmpty(id))
					return null;
				
				TurbineUser user = null;
				/*
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
				*/
				return user;
			}
			
	
public static List<TurbineUser> getUsers() throws Exception {
	
		List<TurbineUser> users = null;
		/*
		Criteria c = new Criteria();
		Integer[] excludedUserIds = {2,33,21,22,23};
		if(!Check.isEmpty(excludedUserIds))
		c.addNotIn(TurbineUserPeer.USER_ID, excludedUserIds);
		c.addAscendingOrderByColumn(TurbineUserPeer.LOGIN_NAME);
		users = TurbineUserPeer.doSelect(c);
		if (users == null) 
			users = new ArrayList<TurbineUser>();
			*/
		return users;
	}


}