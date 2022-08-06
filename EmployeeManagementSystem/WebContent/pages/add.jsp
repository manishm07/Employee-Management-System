<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Information</title>
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
<jsp:include page="include.jsp"/>
<h1>Employee Details</h1>
      <form action="../saveEmp" method="post">
             <table   >
            <tr>
                <td> First Name:</td><td> <input type="text" name="firstName" /></td>
            </tr>
            <tr>
                <td> Last Name:</td><td> <input type="text" name="lastName" ></td>
            </tr>
            <tr>
                <td> Salary:</td> <td><input type="text" name="salary" /></td>
            </tr>
            <tr>
                <td>Age:</td> <td><input type="text" name="age" /></td>
            </tr>
            <tr>
                <td> Email:</td> <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td>submit:</td><td><input type="submit" name="submit" ></td>
            </tr>
             </table>
        </form>

</body>
</html>