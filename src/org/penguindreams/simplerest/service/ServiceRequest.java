package org.penguindreams.simplerest.service;

import javax.servlet.http.HttpServletRequest;

public class ServiceRequest {

	private HttpServletRequest request;
	
	public ServiceRequest(HttpServletRequest request) {		
		this.request = request;
	}
	
	/**
	 * returns the current URL path relative to the context-root and servlet-mapping.
	 * Returns and inclusive path relative to the web applications. For example,
	 * if the context-root is <stong>service</strong> and the servlet-mapping is <strong>rest</strong>, a
	 * URL may look like <strong>http://example.com/service/rest/some/path</strong>. This function would 
	 * return <strong>some/path</strong>.
	 * @return current path excluding web applicaiton location 
	 */
	public String getPath() {
		return request.getRequestURI().substring( request.getContextPath().length() + request.getServletPath().length() );
	}
	
	/**
	 * returns HTTP method.
	 * @return all caps string represeting HTTP method. 
	 */
	public String getMethod() {
		return request.getMethod();
	}
	
}
