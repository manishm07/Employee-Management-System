<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import ="java.util.*" %>
   <%@ include file="intn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% ResourceBundle rb=(ResourceBundle) request.getAttribute("resource"); %>
<%=rb.getString("welcome.message")%>
</head>
<body>


</body>
</html>