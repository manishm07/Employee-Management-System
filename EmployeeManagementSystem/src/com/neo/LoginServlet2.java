package com.neo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		out.println("Hello Servlet from get");
		String un=request.getParameter("userName");
		String pwd=request.getParameter("password");
		if(un.equals("Yogi")&& pwd.equals("Ashok"))
		{
		
			out.print("Login Success from get");
			HttpSession s=request.getSession();
			s.setAttribute("suname",un);
		   RequestDispatcher rd=request.getRequestDispatcher("pages/menu.jsp");
		    rd.forward(request,response);	
		}
		else 
		{
			
			out.print("Login Failed");
			request.setAttribute("msg","invalid login");    //invalid login message
			RequestDispatcher rd=request.getRequestDispatcher("/");
		    rd.forward(request,response);
	}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
