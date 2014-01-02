package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class for Servlet: LoginServlet
 *
 */
 public class LoginServlet extends javax.servlet.http.HttpServlet {
   static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		       request.setAttribute("videos","ÂÞ·ÉÏè");
		       request.getRequestDispatcher("/WEB-INF/json/jsonlogin.jsp").forward(request,response);			  
	}   	  	    
}