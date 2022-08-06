package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neo.modal.Employee;
import com.neo.service.EmployeeService;
import com.neo.service.EmployeeServiceImpl;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService empService=new EmployeeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		out.println("From post");
		Integer id=Integer.parseInt(request.getParameter("eId"));
         String fn=request.getParameter("firstName");
         out.println(fn);
 		String ln=request.getParameter("lastName");
 		  out.println(ln);
 		Double s= Double.parseDouble(request.getParameter("salary"));
 		  out.println(s);
 		Integer a=Integer.parseInt(request.getParameter("age"));
 		  out.println(a);
 		String em=request.getParameter("email");
 		  out.println(em);
 		// RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/list.jsp");
		  // dispatcher.forward(request,response);
 		   
 		  
 		  
	Employee e=new Employee();
	e.setId(id);
	e.setFirstName(fn);
	e.setLastName(ln);
	e.setSalary(s);
	e.setAge(a);
	e.setEmail(em);
	//out.print(e.getFirstName());
	
	empService.updateEmployee(e);
	
	 RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/list.jsp");   //particular page ma pathaune code
	    dispatcher.forward(request,response);
	
	
	}

}
