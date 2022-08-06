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
<h1>Employee Details::<input type="hidden" name="eId" value="${empDetail.getId() }">  </h1>
      <form action="<%=request.getContextPath() %>/editEmpUrl" method="post">
             <table   >
             <tr>
                <td> Id:</td><td> <input type="hidden" name="eId" value="${empDetail.getId() }" /></td>
            </tr>
            <tr>
                <td> First Name:</td><td> <input type="text" name="firstName" value="${empDetail.getFirstName() }" /></td>
            </tr>
            <tr>
                <td> Last Name:</td><td> <input type="text" name="lastName" value="${empDetail.getLastName() }" ></td>
            </tr>
            <tr>
                <td> Salary:</td> <td><input type="text" name="salary"  value="${empDetail.getSalary() }"/></td>
            </tr>
            <tr>
                <td>Age:</td> <td><input type="text" name="age" value="${empDetail.getAge() }" /></td>
            </tr>
            <tr>
                <td> Email:</td> <td><input type="text" name="email" value="${empDetail.getEmail() }" /></td>
            </tr>
            <tr>
                <td>submit:</td><td><input type="submit" name="submit" ></td>
            </tr>
             </table>
        </form>

</body>
</html>