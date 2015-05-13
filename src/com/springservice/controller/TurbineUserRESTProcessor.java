package com.springservice.controller;

import com.springservice.bo.*;
import com.springservice.dao.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class Check
{
	static boolean isEmpty(String str)
	{
			if(str.equals(""))
				return true;			
			return false;
	}
}

public class TurbineUserRESTProcessor extends RESTProcessor  {
	/**
	 * 
	 */

	public ModelAndView doGet(HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("handleRequestInternal");
		HashMap<String, String> data = new HashMap<String, String>();
		String results = null;
		String loginname = request.getParameter("userName");
		String email = request.getParameter("email");
		//String AllUsers = request.getParameter("getallusers");
		/*StatusObject*/ArrayList<String> statusObj = new /*StatusObject*/ArrayList<String>();
		Gson gson=new Gson();

		try
		{

			if (!Check.isEmpty(loginname)) {

				results = getUserByLoginName(loginname);
			} 

			if (!Check.isEmpty(email)) {

				results = getUserByEmail(email);
			}
/*
			if (!Check.isEmpty(AllUsers)){

				results= getUsersList();
			}
			*/
		}catch(Exception e){

		}
		results = gson.toJson(statusObj, new TypeToken</*StatusObject*/ArrayList<String>>(){}.getType());


		data.put(/*RESULTS_VIEW_NAME*/"", results);
		ModelAndView mv = new ModelAndView(/*GET_RESULTS_VIEW_NAME*/"", data);
		return mv;

	}

	//////

	public String getUserByLoginName(String loginname){
		/*StatusObject*/ArrayList<TurbineUser> statusObj = new /*StatusObject*/ArrayList<TurbineUser>();
		Type statusType = new TypeToken</*StatusObject*/ArrayList<TurbineUser>>(){}.getType();
		TurbineUser user =  null;
		Gson gson=new Gson();

		/*try {*/
			user=TurbineUserCore.getTurbineUserByLoginName(loginname);
			/*
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//statusObj.setData(user);
		statusObj.add(user);

		/*String errMessage = config.getErrMessage();
		if(!Check.isEmpty(errMessage)) {
			statusObj.setRc(-1);
			statusObj.setMessage(errMessage);
		} */



		return gson.toJson(statusObj, new TypeToken</*StatusObject*/ArrayList<TurbineUser>>(){}.getType());
	}

	public String getUserByEmail(String email){
		/*StatusObject*/ArrayList<TurbineUser> statusObj = new /*StatusObject*/ArrayList<TurbineUser>();
		Type statusType = new TypeToken</*StatusObject*/ArrayList<TurbineUser>>(){}.getType();
		TurbineUser user =  null;
		Gson gson=new Gson();

		//try {
			user=TurbineUserCore.getTurbineUserByLoginName(email);
			/*
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//statusObj.setData(user);
		statusObj.add(user);

		/*String errMessage = config.getErrMessage();
		if(!Check.isEmpty(errMessage)) {
			statusObj.setRc(-1);
			statusObj.setMessage(errMessage);
		} */

		return gson.toJson(statusObj, new TypeToken</*StatusObject*/ArrayList<TurbineUser>>(){}.getType());
	}

	public String getUsersList(){
		/*StatusObject*/ArrayList<TurbineUser[]> statusObj = new /*StatusObject*/ArrayList<TurbineUser[]>();
		Type statusType = new TypeToken</*StatusObject*/ArrayList<TurbineUser[]>>(){}.getType();
		ArrayList<TurbineUser> users =  null;
		Gson gson = new Gson();

		try {
			users=(ArrayList<TurbineUser>) TurbineUserCore.getUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//statusObj.setData(users.toArray(new TurbineUser[users.size()]));
		statusObj.add(users.toArray(new TurbineUser[users.size()]));


		/*String errMessage = config.getErrMessage();
		if(!Check.isEmpty(errMessage)) {
			statusObj.setRc(-1);
			statusObj.setMessage(errMessage);
		} */

		return gson.toJson(statusObj, statusType);
		//return gson.toJson(statusObj, new TypeToken<StatusObject<TurbineUser>[]>(){}.getType());
	}


	@Override
	public ModelAndView doPost(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView doDelete(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView doPut(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
}