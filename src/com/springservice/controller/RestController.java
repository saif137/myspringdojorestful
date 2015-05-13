package com.springservice.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RestController implements Controller, ApplicationContextAware {
    ApplicationContext appContext = null;
    Collection<IRESTProcessor> restServices = null;
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	System.out.println("\n RestController.handleRequest");
        ModelAndView mv = new ModelAndView();
        
        if (restServices == null) {
            Map<String,IRESTProcessor> beans = appContext.getBeansOfType(IRESTProcessor.class);
            restServices = beans.values();
        }
        
        String URI = request.getRequestURI();
        
        String method = request.getMethod();
        if (method != null && method.trim().length() != 0) {
            method = method.trim().toUpperCase();

            IRESTProcessor restService = getRestService(URI);
            
            try {
                if (restService != null) {
                    if(method.equals("GET")){
                        mv = restService.doGet(request, response);
                    }
                    else if(method.equals("POST")){
                        mv = restService.doPost(request, response); 
                    }
                    else if(method.equals("DELETE")){
                        mv = restService.doDelete(request, response);
                    } else {
                        mv = restService.doPut(request, response);
                    }
                } else {
                    mv = getDefaultError(new Exception("No compatible REST service found to process this request!"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                mv = getDefaultError(e);
            }
        }
        
        return mv;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {
        appContext = ctx;
    }

    private IRESTProcessor getRestService(String uri)
    {
        IRESTProcessor service = null;

        if (restServices != null)
        {
            Iterator<IRESTProcessor> iter = restServices.iterator();

            while (iter.hasNext())
            {
                IRESTProcessor curService = iter.next();

                if (curService.supportsURL(uri))
                {
                    service = curService;
                    break;
                }
            }
        }
        return service;
    }
    
    private ModelAndView getDefaultError(Exception e) {
        HashMap<String, String> data = new HashMap<String, String>();
        StatusObject<String> statusObj = new StatusObject<String>();
        Gson gson = new Gson();
        
        statusObj.setRc(RESTError.ERROR);
        statusObj.setMessage(e.toString());
        String results = gson.toJson(statusObj, new TypeToken<StatusObject<String>>(){}.getType());
        
        data.put("results", results);
        return new ModelAndView("getResults", data);
    }
}