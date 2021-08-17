<%@page import="com.revature.ibaw.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer details</h2>
	<%
	Customer customer = (Customer)session.getAttribute("PresentCustomerDetails");
	%>
	<table cellpadding="10" cellspacing="10">
		<th>Customer CifId</th>
		<th>Customer First Name</th>
		<th>Customer Last Name</th>
		<th>Username</th>
		<th>Account Number</th>
		<th>Account Balance</th>
		<th>Account Creation Date</th>
		<tr>
			<td><%=customer.getCustomerCifId()%></td>
			<td><%=customer.getCustomerFirstName()%></td>
			<td><%=customer.getCustomerLastName()%></td>
			<td><%=customer.getCustomerUserName()%></td>
			<td><%=customer.getAccountNumber()%></td>
			<td><%=customer.getAccountBalance()%></td>
			<td><%=customer.getDateOfAccountCreation()%></td>

		</tr>

	</table>

	</table>
</body>
</html>
