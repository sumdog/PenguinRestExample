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
		
		ServiceRequest serviceRequst = new ServiceRequest(request);
		
		
		
	}
	
	
}
