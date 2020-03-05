<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display</title>
<style type="text/css">
	th {
		background:orange;
		color:white;
	}
	h3 {
		color:red;
	}
</style>
</head>
<body>
<center>
<h2> Display Student Record</h2>
<table border="4" width="100%">
	<tr>
		<th>Empcode</th>
		<th>Employee Name</th>
		<th>Address</th>
		<th>Designation</th>
		<th>Mobile</th>
		<th>Email</th>
	</tr>
	<c:forEach var="tab" items="${data }">
	<tr>
		<td style="text-transform: capitalize;"> ${tab.empcode } </td>
		<td style="text-transform: capitalize;"> ${tab.empname }</td>
		<td style="text-transform: capitalize;"> ${tab.address } </td>
		<td style="text-transform: capitalize;"> ${tab.designation }</td>
		<td> ${tab.mobile }</td>
		<td style="text-transform: lowercase;"> ${tab.email }</td>
	</tr>
	</c:forEach>
</table>
<h3>${msg }</h3>
</center>
</body>
</html>