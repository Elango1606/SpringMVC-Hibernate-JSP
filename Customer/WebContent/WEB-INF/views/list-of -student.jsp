<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
<div align = "center">
<h1> List of Student</h1>
<table border="1">
	<tr>
		<th> FirstName	</th>
		<th> LastName	</th>
		<th> Email		</th>
		<th> Action		</th>
	<tr>
<c:forEach var="tempCustomer" items="${VALUES}">

	<c:url var="UpdateLink" value = "/updateForm">
		<c:param name="CustomerId" value="${tempCustomer.id}"></c:param>
	</c:url>
	<c:url var="DeleteLink" value = "/deleteCustomer">
		<c:param name="CustomerId" value="${tempCustomer.id}"></c:param>
	</c:url>
	<tr>
		<td>	${tempCustomer.firstName}	</td>
		<td>	${tempCustomer.lastName}	</td>
		<td>	${tempCustomer.email}		</td>
		<td>	<a href="${UpdateLink}">Update</a>
		|	
		<a href="${DeleteLink}" onclick = "if(!(confirm('Are you sure you want to delete this Student?'))) return false">Delete</a>	
		</td>
	</tr>
</c:forEach>
</table>
</div>
<br/>
<div align="center"><a href = "/Customer/">Back to Home Page </a> </div>
</body>
</html>