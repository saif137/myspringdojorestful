package com.springservice.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

public abstract class RESTProcessor implements IRESTProcessor {
    protected String supportedURLPattern = null;
    protected AntPathMatcher matcher = new AntPathMatcher();
    
    protected static String GET_RESULTS_VIEW_NAME = "getResults";
    protected static String RESULTS_VIEW_NAME = "results";
    
    protected Gson gson = new Gson();
    
    @Override
    public void setSupportedURLPattern(String url) {
        supportedURLPattern = url;
    }

    @Override
    public String getSupportedURLPattern() {
        return supportedURLPattern;
    }

    @Override
    public abstract ModelAndView doPost(HttpServletRequest request,
            HttpServletResponse response);

    @Override
    public abstract ModelAndView doGet(HttpServletRequest request,
            HttpServletResponse response); 

    @Override
    public abstract ModelAndView doDelete(HttpServletRequest request,
            HttpServletResponse response);

    @Override
    public abstract ModelAndView doPut(HttpServletRequest request,
            HttpServletResponse response);

    @Override
    public boolean supportsURL(String urlString) {
        return matcher.match(supportedURLPattern, urlString);
    }

    protected String getJSONFromRequestBody(HttpServletRequest request) 
    {
        String data = null;
        try {
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();     
            String line = reader.readLine();     
            while (line != null) {         
                sb.append(line + "\n");         
                line = reader.readLine();     
            }     
            reader.close();     
            data = sb.toString();  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }     
        
        return data;
    }
    
    protected boolean isUserLoggedIn(HttpServletRequest request) 
    {
        boolean isLoggedIn = false;
    /*    
        JetspeedUser user = SecurityUtils.fetchThisJSUser(request);
        if (user != null) {
            isLoggedIn = user.hasLoggedIn();
        }
    */    
        return isLoggedIn;
    }
}