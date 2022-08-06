<%@ page language="java" contentType="text/html; charset=UTF-8" 
        pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.neo.service.EmployeeService" %>
<%@ page import="com.neo.service.EmployeeServiceImpl" %>
<%@ page import="com.neo.modal.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Employees </title> 
<style>
table {
  width:100%;

  
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>
</head>


<%
    EmployeeService es=new EmployeeServiceImpl();
     List<Employee> employeeList=es.allEmployees();
     request.setAttribute("employeeList",employeeList);
                    
%>
    <%@ include file="header.jsp"%>
    <%@ include file="include.jsp" %><br><br>
    
    <table>
        <thead>
            <tr>
                <th colspan="8">List of Employees With Details::<c:out value="${msg}"/></th>   <!-- -c: is a  jstl tag -->
            </tr>
            <tr>
                <th>S.No.<%--${fn:length(employeeList)}--%><br/></th>
                <th>First Name</th>
                 <th>Last Name</th>
                  <th>Salary</th>
                   <th>Age</th>
                    <th>Email</th>
        <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            
            <c:forEach items="${employeeList}" var="emp">
                <tr align="center" >
                    <td><c:out value="${emp.id}"/></td>
                     <td>${emp.firstName}</td>
                      <td><c:out value="${emp.lastName}"/></td>
                       <td><c:out value="${emp.salary}"/></td>
                        <td><c:out value="${emp.age}"/></td>
                        <%--<td><>fmt:formatDate pattern="yyyy-MMM--dd" value="${user.dob}"/></td>--%>
                        <td><c:out value="${emp.email}"/></td>
                       
                       <td><a href="<%=request.getContextPath()%>/empUrl?action=edit&eId=<c:out value="${emp.id}"/>">Update</a></td>   <!-- request.getContextpath() will give you your project name -->
                                  
                       <td><a href="<%=request.getContextPath()%>/empUrl?action=delete&eId=<c:out value="${emp.id}"/>">Delete</a></td>
                
                </tr>
                </c:forEach>
        </tbody>
    </table>