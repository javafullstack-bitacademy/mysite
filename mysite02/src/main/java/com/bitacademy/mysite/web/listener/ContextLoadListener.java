package com.bitacademy.mysite.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ContextLoadListener
 *
 */
public class ContextLoadListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		String contextConfigLocation = context.getInitParameter("contextConfigLocation");
		
		System.out.println("Application Starts...." + contextConfigLocation);
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}

}
