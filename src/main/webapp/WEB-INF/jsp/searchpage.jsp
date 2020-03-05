<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search</title>
<style type="text/css">
	th {
		background:orange;
		color:white;
	}
	h2 {
		color:red;
	}
	.tablecolor {
		background:orange;
		color:white;
		margin-top:5%;
	}
</style>
</head>
<body>
<center>
<form:form action="searchdata" method="post" modelAttribute="bean">
	<table border="10" class="tablecolor">
		<tr>
			<th colspan="2">SEACRH RECORD</th>
		</tr>
		<tr>
			<th>Enter Empcode :</th>
			<td><form:input path="empcode"/></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="Search"></td>
		</tr>
	</table>
</form:form>
<br/><hr/>
<h2>${msg }</h2>
	<table border="3" width="100%">
	<tr>
		<th>Empcode</th>
		<th>Employee Name</th>
		<th>Address</th>
		<th>Designation</th>
		<th>Mobile</th>
		<th>Email</th>
	</tr>
	<c:forEach var="tab" items="${li }">
	<tr>
		<td style="text-transform: capitalize;"> ${tab.empcode } </td>
		<td style="text-transform: capitalize;"> ${tab.empname }</td>
		<td style="text-transform: capitalize;"> ${tab.address } </td>
		<td style="text-transform: capitalize;"> ${tab.designation }</td>
		<td style="text-transform: capitalize;"> ${tab.mobile }</td>
		<td style="text-transform: capitalize;"> ${tab.email }</td>
	</tr>
	</c:forEach>
</table>
</center>
</body>
</html>