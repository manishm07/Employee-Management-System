<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login details</title>
</head>
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
<body>

<h1>Login Credentials:</h1>
   ${msg}
 <form action="login" method="post">
             <table >
            <tr>
                <td> UserName:</td><td> <input type="text" name="userName" value="Yogi"/></td>
            </tr>
            <tr>
                <td> Password:</td> <td><input type="text" name="password" value="Ashok"/></td>
            </tr>
            <tr>
                <td>submit   :</td><td><input type="submit" name="login" value="login"/></td>
            </tr>
             </table>
        </form>

</body>
</html>