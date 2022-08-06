<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<table  >
	<tr align="right">
		<td>Logged In User::<% out.print(session.getAttribute("suname").toString().toUpperCase());%></td>
	</tr>

</table>