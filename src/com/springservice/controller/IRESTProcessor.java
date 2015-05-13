package com.springservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface IRESTProcessor {

	ModelAndView doGet(HttpServletRequest request, HttpServletResponse response);

	ModelAndView doPost(HttpServletRequest request, HttpServletResponse response);

	ModelAndView doDelete(HttpServletRequest request,
			HttpServletResponse response);

	ModelAndView doPut(HttpServletRequest request, HttpServletResponse response);

	boolean supportsURL(String uri);

	void setSupportedURLPattern(String url);

	String getSupportedURLPattern();

}
