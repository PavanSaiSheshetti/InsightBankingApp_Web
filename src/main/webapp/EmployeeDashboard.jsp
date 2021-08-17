<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="JS/validateEmployeeOperations.js">
</script>
</head>
<body>

<div onclick=getBalance()> Get Customer Balance</div>

<div id="getBalanceSection" style=display:none>
<form action="EmployeeOperationsServlet?operation=getBalance" onsubmit="return validateAccount()" method="post">
Enter Account Number :<input type="number" id="accountNumberB" name="accountNumberB" placeholder="enter account number" onblur="validateAccount()" /><br/>
<br/><input type=submit value='Get Balance' /> &nbsp;&nbsp;<input type="reset"  value="clear" class="reset"><br/>
<font color='red'><h6 id="account_errorB"></h6></font>
</form>
</div>

<div onclick=getCustomerDetails()> Get Customer Details </div>

<div id="getCustomerDetails" style=display:none>
<form action="EmployeeOperationsServlet?operation=getCustomerDetails" onsubmit="return validateAccountt()" method="post">
Enter Account Number :<input type="number" id="accountNumberC" name="accountNumberC" placeholder="enter account number" onblur="validateAccountt()" /><br/>
<br/><input type=submit value='Get Customer Details' /> &nbsp;&nbsp;<input type="reset"  value="clear" class="reset"><br/>
<font color='red'><h6 id="account_errorC"></h6></font>
</form>
</div>

<form action="EmployeeOperationsServlet?operation=getBankAccounts" method="post">
<h1><input type="submit" value='Get Bank Account Details' id='getBankAccounts'/></h1>
</form>
<div onclick=approve()> Approve Account</div>

<div id="approveAccount" style=display:none>
<form action="EmployeeOperationsServlet?operation=approveAccount" onsubmit="return validateAccounttt()" method="post">
Enter Account Number :<input type="number" id="accountNumberA" name="accountNumberA" placeholder="enter account number" onblur="validateAccounttt()" /><br/>
<br/><input type=submit value='Approve Account' /> &nbsp;&nbsp;<input type="reset"  value="clear" class="reset"><br/>
<font color='red'><h6 id="account_errorA"></h6></font>
</form>
</div>

<form action="EmployeeOperationsServlet?operation=log" method="post">
<h1><input type="submit" value='View Log' /></h1>
</form>

<form action="EmployeeOperationsServlet?operation=logout" method="post">
<h1><input type="submit" value='Logout' /></h1>
</form>

</body>
</html>