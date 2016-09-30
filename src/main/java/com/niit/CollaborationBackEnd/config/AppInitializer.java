package com.niit.CollaborationBackEnd.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses Working");
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class[] getServletConfigClasses() {
	
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings Working");

		return new String[] { "/" };
	}
	
}
