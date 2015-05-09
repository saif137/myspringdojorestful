package com.springservice.controller;
 
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

//import com.fasterxml.jackson.databind.ObjectMapper;
  




import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.springservice.bo.greetingbo;
import com.springservice.bo.userbo;
import com.springservice.dao.userdao;
import com.sun.jersey.api.json.JSONWithPadding;

@RestController
@RequestMapping(value = "/")
public class SpringServiceController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final userdao tempdao = new userdao();
	
    //Redirect on startup to default index.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView method() {
            return new ModelAndView("redirect:" + "index.jsp");

    }
    
	@RequestMapping(value = "/userinfo/getAll"
	 		, method = RequestMethod.GET
	 		)
		public  @ResponseBody String getAll() {
		Gson gson=new Gson();
		return gson.toJson(tempdao.getAll());
		}
    
	@RequestMapping(value = "/userinfo/getByFname"
	 		, method = RequestMethod.GET
	 		)
		public  @ResponseBody String getByFname() {
		Gson gson=new Gson();
		return gson.toJson(tempdao.getAll());
		}
    
	@RequestMapping(value = "/userinfo/getByFname/{fname}"
			 		, method = RequestMethod.GET
			 		)
	 public  @ResponseBody String getByFname(@PathVariable String fname) {
		userbo temp = tempdao.getByFname(fname);
		if(temp == null)
		{
			System.out.println("fname " + fname + " not found");
			return "{\"fname\":\"notfound\"}";
		}
		Gson gson=new Gson();
		System.out.println("fname " + temp.getFname() + " found");
        return gson.toJson(temp);
	 }
	
	@RequestMapping(value = "/userinfo/getByLname"
	 		, method = RequestMethod.GET
	 		)
		public  @ResponseBody String getByLname() {
		Gson gson=new Gson();
		return gson.toJson(tempdao.getAll());
		}
	
	@RequestMapping(value = "/userinfo/getByLname/{lname}"
			 		, method = RequestMethod.GET
			 		)
	 public  @ResponseBody String getByLname(@PathVariable String lname) {
		userbo temp = tempdao.getByLname(lname);
		if(temp == null)
		{
			System.out.println("lname " + lname + " not found");
			return "{\"lname\":\"notfound\"}";
		}
		Gson gson=new Gson();
		System.out.println("lname " + temp.getFname() + " found");
	    return gson.toJson(temp);
	 }	
	
	@RequestMapping(value = "/userinfo/getByEmail"
	 		, method = RequestMethod.GET
	 		)
		public  @ResponseBody String getByEmail() {
		Gson gson=new Gson();
		return gson.toJson(tempdao.getAll());
		}
	
	@RequestMapping(value = "/userinfo/getByEmail/{email}"
			 		, method = RequestMethod.GET
			 		)
	 public  @ResponseBody String getByEmail(@PathVariable String email) {
		userbo temp = tempdao.getByEmail(email);
		if(temp == null)
		{
			System.out.println("email " + email + " not found");
			return "{\"email\":\"notfound\"}";
		}
		Gson gson=new Gson();
		System.out.println("email " + temp.getFname() + " found");
	    return gson.toJson(temp);
	 }		
	
	/*
	 * Below code was used during prototyping
	 */
	
	 @RequestMapping(value = "/userinfo/greeting"
			 		, method = RequestMethod.GET
			 		,headers="Accept=application/javascript "
			 		,produces = {"application/x-javascript"}
			 		)
	 public  @ResponseBody JSONWithPadding getGreeting(
			 @RequestParam(value="name", defaultValue="default") String name
			 , @RequestParam("callback") String callback) {
	     
			 /*
			 return new greetingbo(counter.incrementAndGet(),
		             String.format(template, name));
		     */
		 	/*
	     	Gson gson=new Gson();
	        String jsonResponse=gson.toJson(new greetingbo(counter.incrementAndGet(),
		             String.format(template, name)));
	        return jsonResponse;
	        */
	        return new JSONWithPadding(new greetingbo(counter.incrementAndGet(),
		             String.format(template, name)), callback);
	 }
	 //http://localhost:8137/userinfo/jsonweb/greeting
	 //http://localhost:8137/jsonweb/userinfo/greeting?name=saif
 
		
	 //Below code is used during working for prototyping
	    /*
	    //Redirect on startup to default index.jsp
	    @RequestMapping(value = "/restconsumer", method = RequestMethod.GET)
	    public ModelAndView restconsumer(HttpServletRequest request, HttpServletResponse response) {
	    		RestTemplate restTemplate = new RestTemplate();
	    		ArrayList<userbo> obj = restTemplate.getForObject("http://graph.facebook.com/pivotalsoftware", (ArrayList<userbo>).class);
	            return new ModelAndView("redirect:" + "restconsumer.jsp").addObject(obj);

	    }
	    */

	 /*
	  * Work around using custom method
	 @RequestMapping(value = "/greeting"
			 		, method = RequestMethod.GET
			 		//,headers="Accept=application/json"
			 		,produces = {"application/x-javascript"})
	 public  @ResponseBody String getGreeting(@RequestParam(value="name", defaultValue="default") String name) {
	     return convertToJsonP(new Greeting(counter.incrementAndGet(),
	             String.format(template, name)), name);
	 }
	 //http://localhost:8137/jsonweb/greeting
	 //http://localhost:8137/jsonweb/greeting?name=saif
	 
	 private String convertToJsonP(Object o,String jsonpCallback){
	        String outputmessage=null;
	        ObjectMapper mapper = new ObjectMapper();
	        try {
	            outputmessage=mapper.writeValueAsString(o);
	        } catch (Exception e) {
	            // TODO Auto-generated private String convertToJsonP(Object o,String jsonpCallback){
	            try {
	                outputmessage=mapper.writeValueAsString(o);
	            } catch (Exception e2) {
	                // TODO Auto-generated catch block
	                e2.printStackTrace();
	            }
	            if(outputmessage!=null){
	                outputmessage=jsonpCallback + "(" + outputmessage + ")";
	            }
	            return outputmessage;   
	        }
	        if(outputmessage!=null){
	            outputmessage=jsonpCallback + "(" + outputmessage + ")";
	        }
	        return outputmessage;   
	    }
	  */
	 
}