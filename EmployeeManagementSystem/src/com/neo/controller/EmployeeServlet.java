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

@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService empService=new EmployeeServiceImpl();
       
    
    public EmployeeServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action="";
		PrintWriter out= response.getWriter();
		Integer id=0;
		if(request.getParameter("eId") != null) {
			 id=Integer.parseInt(request.getParameter("eId"));    //list ko data 0 pugepaxi yo use garne
		}
		
		if(request.getParameter("action")!=null)    //data deleted garne code get mai hunu parxa
		{
			action=request.getParameter("action");
			if(action.equals("delete")) {
				out.println("delete");
				empService.deleteEmployee(id);
				request.setAttribute("msg","Data deleted successfully!!");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/list.jsp");
				    dispatcher.forward(request,response);
				
			}  else if(action.equals("edit")) {
				out.print("....edit action"  + id);
				out.println("edit");
				Employee emp=empService.employeeById(id);
				request.setAttribute("empDetail",emp);
				 RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/edit.jsp");   //particular page ma pathaune code
				    dispatcher.forward(request,response);
				
			}
			
		}
		
      
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		   PrintWriter out=response.getWriter();
	         out.println("Hello Servlet from EmployeeServlet");
	         Integer id = 0;
	         if(request.getParameter("eId") != null) {
	        	  id=Integer.parseInt(request.getParameter("eId")); 
	        	 
	         }
	           //casting garnu parxa because string ma aauxa..
	         out.println(id);
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
	 		 RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/list.jsp");
			    dispatcher.forward(request,response);
	 		   
	 		  
	 		  
		Employee e=new Employee();
		e.setFirstName(fn);
		e.setLastName(ln);
		e.setSalary(s);
		e.setAge(a);
		e.setEmail(em);
		//out.print(e.getFirstName());
		
		empService.saveEmployee(e);
		
		
		Integer empSize= empService.allEmployees().size();
		out.println("size.."+empSize);
		
		
	}

}
