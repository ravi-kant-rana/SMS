<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
<style type="text/css">
	table {
		background:orange;
		color:white;
		margin-top:5%;
	}
	h3 {
		color:green;
	}
</style>
</head>
<body>
<center>
<h3>${msg }</h3>
	<form:form action="insertdata" method="post" modelAttribute="bean">
		<table border="10">
		<tr>
			<th colspan="2"> REGESTRACTION</th>
		</tr>
			<tr>
				<th>Enter Name</th>
				<td><form:input path="empname" style="text-transform: capitalize;"/>
				</td>
			</tr>
			<tr>
				<th>Enter Address</th>
				<td><form:input path="address" style="text-transform: capitalize;"/></td>
			</tr>
			<tr>
				<th>Enter Designation</th>
				<td><form:input path="designation" style="text-transform: capitalize;"/></td>
			</tr>
			<tr>
				<th>Enter Mobile</th>
				<td><form:input path="mobile"/></td>
			</tr>
			<tr>
				<th>Enter Email</th>
				<td><form:input path="email" style="text-transform: capitalize;"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</center>
</body>
</html>