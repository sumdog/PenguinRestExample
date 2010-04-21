/*
* Sumit Khanna - PenguinDreams.org 
* 
* For educational use only. 
*/
package org.penguindreams.simplerest.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServiceHandler extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getMethod();
		
		String path = request.getRequestURI().substring( request.getContextPath().length() + request.getServletPath().length() );
		
		response.getWriter().write("Path" + path);
		
		response.getWriter().close();
		
		
	}
	
	
}
