package com.springservice.controller;

//Import required java libraries
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.springservice.bo.TurbineUser;
import com.springservice.dao.TurbineUserCore;

//Extend HttpServlet class
public class ServletController extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		TurbineUserCore.Init();
	}
	
	public void doGet(HttpServletRequest request,
	                 HttpServletResponse response)
	         throws ServletException, IOException
	{
		// Set response content type
		response.setContentType("json");
	
	   PrintWriter out = response.getWriter();
	   if(request.getParameter("op").equals("getallusers"))
	   {
		   Gson gson=new Gson();			
		   out.println(gson.toJson(TurbineUserCore.getUsers()));		   
	   }
	   else if(request.getParameter("op").equals("getbyusername"))
	   {
		   Gson gson=new Gson();	
		   TurbineUser res = TurbineUserCore.getTurbineUserByLoginName(request.getParameter("userName"));
		   if (res == null)
		   {
			   out.print("{\"userName\":\"Not found\"}");			   
		   }
		   else
		   {
			   out.print(gson.toJson(res));
		   }
	   }
	   else if(request.getParameter("op").equals("getbyemail"))
	   {
		   Gson gson=new Gson();			
		   TurbineUser res = TurbineUserCore.getTurbineUserByEmail(request.getParameter("email"));
		   if(res == null)
		   {
			   out.print("{\"email\":\"Not found\"}");		   

		   }
		   else
		   {
			   out.print(gson.toJson(res));		   
		   }
	   }
	   else if(request.getParameter("op").equals("getbyboth"))
	   {
		   Gson gson=new Gson();	
		   JsonArray ja = new JsonArray();
		   TurbineUser resuser = TurbineUserCore.getTurbineUserByLoginName(request.getParameter("userName"));
		   if (resuser == null)
		   {
			   ja.add(new JsonParser().parse("{\"userName\":\"Not found\"}"));
		   }
		   else
		   {
			   ja.add(new JsonParser().parse(gson.toJson(resuser)));
		   }
		   
		   TurbineUser resemail = TurbineUserCore.getTurbineUserByEmail(request.getParameter("email"));
		   if(resemail == null)
		   {
			   ja.add(new JsonParser().parse("{\"email\":\"Not found\"}"));		   

		   }
		   else
		   {
			   ja.add(new JsonParser().parse(gson.toJson(resemail)));		   
		   }
		   out.print(gson.toJson(ja));
	   }
	   out.close();
	}
	
	//Method to handle POST method request.
	public void doPost(HttpServletRequest request,
	                  HttpServletResponse response)
	   throws ServletException, IOException {
	  doGet(request, response);
	}
}