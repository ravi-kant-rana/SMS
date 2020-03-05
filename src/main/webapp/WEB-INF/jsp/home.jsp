<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<style type="text/css">
	table {
		background:orange;
		margin-top:2%;
	}
	a {
		color:white;
		font-size:20px;
		text-decoration: none;
	}
	h3 {
		color:blue;
	}
</style>
</head>
<body>
<h3>${msg }</h3>
<h3>${msgs }</h3>
<center>
		<table border="10" width="300px;">
			<tr>
				<th><a href="register">Register</a></th>
			</tr>
			<tr>
				<th><a href="display">Display</a></th>
			</tr>
			<tr>
				<th><a href="search">Search</a></th>
			</tr>
			<tr>
				<th><a href="advsearch">Advance Search</a></th>
			</tr>
			<tr>
				<th><a href="logout">Logout</a></th>
			</tr>
		</table>
	</center>
</body>
</html>