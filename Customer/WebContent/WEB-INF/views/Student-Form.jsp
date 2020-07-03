<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form </title>
</head>
<body>
<div align ="center">
<h1> Registration Form </h1>
<br/>
<style>
.error{color:red;}
</style>
<form:form action = "processing" modelAttribute="FORM" method="POST">
<form:hidden path="id"/>
<table> 
	<tr>
		<th>
			<label>	FirstName </label>
			<form:input path="firstName"/>
			<form:errors path="firstName" cssClass="error"/>
		</th>
	</tr>
	<tr>	
		<th>
			<label>	LastName	</label>
			<form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
		</th>
	</tr>
	<tr>	
		<th>
			<label>	Email	</label>
			<form:input path="email"/>
			<form:errors path="email" cssClass="error"/>
		</th>
	</tr>
	<tr>	
		<th>
		<input type="submit" name ="Submit"/>
		<input type="button" value ="Cancel" onclick = "window.location.href='/Customer/form'; return false;"/>
		</th>
	</tr>
</table>
</form:form>
<div align = "center"> 
<a href="/Customer"> Back to Home Page</a>
</div>
</div>
</body>
</html>