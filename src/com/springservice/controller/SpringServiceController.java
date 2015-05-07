package com.springservice.controller;
 
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
  
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class SpringServiceController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	
	 @RequestMapping(value = "/greeting"
			 		, method = RequestMethod.GET
			 		//,headers="Accept=application/json"
			 		//,produces = {"application/x-javascript"}
			 		)
	 public  @ResponseBody String getGreeting(@RequestParam(value="name", defaultValue="default") String name) {
	     
		 /*
		 return new Greeting(counter.incrementAndGet(),
	             String.format(template, name));
	     */
	     Gson gson=new Gson();
	        String jsonResponse=gson.toJson(new Greeting(counter.incrementAndGet(),
		             String.format(template, name)));
	        return jsonResponse;
	 }
	 //http://localhost:8137/jsonweb/greeting
	 //http://localhost:8137/jsonweb/greeting?name=saif
 
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