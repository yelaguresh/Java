<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<form action="customerOperation">
		<h1>Welcome to home page</h1>
		<br>
		<h2>Select the customer operation to be performed</h2>
		<br> <select name="operationType">
			<option value="">Please select the operation you wish to
				perform</option>
			<option value="create">Create Customer</option>
			<option value="read">Read Customer</option>
			<option value="update">Update Customer</option>
			<option value="delete">Delete Customer</option>
		</select><br> <input type="submit" value="Next">
	</form>
</body>
</html>