<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<body>
<a href ="<%=request.getContextPath()%>/intnUrl?language=en&country=US">English US user</a><br>
<a href ="<%=request.getContextPath()%>/intnUrl?language=it">Italian User</a><br>
</body>
</html>