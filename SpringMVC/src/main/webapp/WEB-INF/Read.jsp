<%@page import="imcs.trng.pojo.Customers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Customer Data</title>
<h3>Enter the Customer id to be read</h3>
</head>
<body>
	<form action="readCustomer">
		Customer Id: <input type="text" name="id"><br> 
		<input
			type="submit" value="Read" />
	</form>
	{result}
</body>
</html>