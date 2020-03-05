<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<style type="text/css">
	h3 {
		color:red;
	}
	table {
		background:orange;
		color:white;
		margin-top:10%;
	}
</style>
</head>
<body>
<center>
	<form:form action="checklogin" method="post" modelAttribute="bean">
		<table border="10">
			<tr>
				<th colspan="2">--- EMPLOYEE LOGIN ---</th>
			</tr>
			<tr>
				<th>Enter Name</th>
				<td><form:input path="empname" style="text-transform: capitalize;"/></td>
			</tr>
			<tr>
				<th>Enter Mobile</th>
				<td><form:input path="mobile"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</center>
</body>
</html>