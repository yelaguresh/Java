<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Form</title>
</head>
<body>
	<form action="deleteCustomer">
		<h1>Delete Customers</h1>
		Customer Number<input type="text" name="customerNumber" /><br> <input
			type="submit" value="Delete" />
		<%
			out.print(request.getAttribute("delete"));
		%>
		<a href="CustomerHome.jsp">Home</a>
	</form>
</body>
</html>