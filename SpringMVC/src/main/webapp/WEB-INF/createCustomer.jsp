<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Customer</title>
</head>
<body>
	<form action="createCustomer">
		<h1>Form to create Customer Record</h1>
		Customer Number: <input type="text" name="customerNumber"><br>
		Customer Name: <input type="text" name="customerName"><br>
		Contact Lastname:<input type="text" name="contactLastName"><br>
		Contact Firstname:<input type="text" name="contactFirstName"><br>
		Phone:<input type="text" name="phone"><br> AddressLine1:<input
			type="text" name="addressLine1"><br> AddressLine2:<input
			type="text" name="addressLine2"><br> City:<input
			type="text" name="city"><br> State:<input type="text"
			name="state"><br> Postal Code:<input type="text"
			name="postalCode"><br> Country:<input type="text"
			name="country"><br> Sales Representative Number:<input
			type="text" name="salesRepEmployeeNumber"><br> Credit
		Limit:<input type="text" name="creditLimit"><br> <input
			type="submit" value="Create"> 

	</form>
	{Result}
</body>
</html>