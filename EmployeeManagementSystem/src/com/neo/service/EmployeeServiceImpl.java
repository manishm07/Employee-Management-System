package com.neo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Connection;
import com.neo.modal.Employee;
import com.neo.util.DbConnection;

public class EmployeeServiceImpl implements EmployeeService
{
	Connection con=null;    //JDBC code
	PreparedStatement ps=null;  //database query
	
	
	@Override
	public void saveEmployee(Employee emp) {
		try {
			con=DbConnection.getDbConnection();
			String sql="INSERT INTO employee(firstName, lastName,salary,age,email) VALUES (?,?,?,?,?)";   //Database
			ps=con.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getEmail());
			int i=ps.executeUpdate();
			System.out.println("Data Inserted Successfully With Id..."+i);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	 public List<Employee> allEmployees(){
		 
	 List<Employee> empList=null;
		 try {
			try {
				con=DbConnection.getDbConnection();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql="SELECT * FROM employee";  //Database
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();  //select operation
			
			while(rs.next()){
				if(empList==null) {
					empList=new ArrayList<Employee>();
			}
				
			Employee e=new Employee();
			e.setId(rs.getInt("id"));
			e.setFirstName(rs.getString("firstName"));
			e.setLastName(rs.getString("lastName"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			e.setEmail(rs.getString("email"));
			empList.add(e);	
		 } 
		 
			
			
	 }catch(SQLException e2) {
		e2.printStackTrace();
		}
	
	// System.out.println("ssize.."+empList.size());
	 return empList;
	 }
	 
	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		try {
			con=DbConnection.getDbConnection();        
			String sql="DELETE FROM employee WHERE id=?";
			ps=con.prepareStatement(sql);         //connector code
			ps.setInt(1, id);             // set id to delete
			ps.executeUpdate();         
			System.out.println("Data Deleted Successfully of id::"+id);     //
			
		}catch(ClassNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
			
		}catch(SQLException e)
		{
			e.getMessage();
			
		}finally {
			try {
				ps.close();
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
		
		
	}
	public Employee employeeById(Integer id) {
		Employee e=null;
		try {
		con=DbConnection.getDbConnection();
		String sql="SELECT *FROM employee WHERE id=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			e=new Employee();
			e.setId(rs.getInt("id"));
			e.setFirstName(rs.getString("firstName"));
			e.setLastName(rs.getString("lastName"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			e.setEmail(rs.getString("email"));
		}
				
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return e;
		
	}
	@Override
	public void updateEmployee(Employee emp) {
		
		try{
			con=DbConnection.getDbConnection();
			String sql="UPDATE employee SET firstName=?,lastName=?,salary=?,age=?,email=? WHERE id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getEmail());
			ps.setInt(6, emp.getId());
			
			int id=ps.executeUpdate();
			
			System.out.println(id+"...UpdatedId.."+emp.getId());
			
		}catch (Exception ex) {
			System.out.println("Exception from catch block");
			
		}

	}

}

	 



