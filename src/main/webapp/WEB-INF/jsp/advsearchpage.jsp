<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>advance search</title>
<style type="text/css">
	th {
		background:orange;
		color:white;
	}
	.warning {
		color:orange;
	}
	.success {
		color:green;
	}
	.danger {
		color:red;
	}
	.tabcolor {
		background:orange;
		color:white;
	}
	.btnupdate {
		background:green;
		color:white;
	}
	.btndelete {
		background:red;
		color:white;
	}
</style>
</head>
<body>
<center>
	<h1>Advance Record Search</h1>
</center>
<form:form action="advfind" method="post" modelAttribute="bean">
	<table width="100%" height="50px;" class="tabcolor">
		<tr>
			<th>Enter Empcode :</th>
			<th>Enter Name :</th>
			<th>Enter Address :</th>
			<th>Enter Designation :</th>
			<th>Enter Mobile :</th>
			<th>Enter Email :</th>
		</tr>
		<tr>
			<th><form:input path="empcode"/></th> 
			<th><form:input path="empname" style="text-transform: capitalize;"/></th> 	
			<th><form:input path="address" style="text-transform: capitalize;"/></th> 
			<th><form:input path="designation" style="text-transform: capitalize;"/></th>
			<th><form:input path="mobile"/></th> 
			<th><form:input path="email" style="text-transform: capitalize;"/></th> 
			<td><input type="submit" value="Search"></td>
		</tr>
	</table>
</form:form>
<br/>
<hr/>
<center> <h3 class="warning">${msg }</h3> </center>
<center> <h3 class="success">${msgs }</h3> </center>
<center> <h3 class="dander">${dmsg }</h3> </center>
<table border="3" width="100%">
	<tr>
		<th>Empcode</th>
		<th>Name</th>
		<th>Address</th>
		<th>Designation</th>
		<th>Mobile</th>
		<th>Email</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="tab" items="${li }">
	<form action="update" method="post" modelAttribute="bean">
	<tr>
		<td> <input type="text" value="${tab.empcode }" name="empcode" readonly></td>
		<td> <input type="text" value="${tab.empname }" name="empname" style="text-transform: capitalize;"> </td>
		<td> <input type="text" value="${tab.address }" name="address" style="text-transform: capitalize;"> </td>
		<td> <input type="text" value="${tab.designation }" name="designation" style="text-transform: capitalize;"></td>
		<td> <input type="text" value="${tab.mobile }" name="mobile"></td>
		<td> <input type="text" value="${tab.email }" name="email" style="text-transform: capitalize;"></td>
		<td align="center"><input type="submit" value="UPDATE" class="btnupdate"></form></td>
		<td align="center">
			<form action="delete" method="post" modelttribute="bean">
				<input type="hidden" value="${tab.empcode }" name="empcode">
				<input type="submit" value="DELETE" class="btndelete">
			</form>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>