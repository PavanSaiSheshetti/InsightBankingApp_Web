<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="JS/validateCustomerOperations.js">
</script>
<script>
function viewBalance(){
	document.getElementById("getBalance").style.display="block";
	document.getElementById("depositSection").style.display="none";
	document.getElementById("withdrawSection").style.display="none";
	document.getElementById("transferSection").style.display="none";
	<% long balance=(long)session.getAttribute("accountBalance");%>
	document.getElementById("getBalance").innerHTML="Your balance is INR "+<%= balance %>;
}
</script>
</head>
<body>
<h1 id=loginSuccess></h1>
<div onclick="viewBalance()" >View Balance</div><h2 id="getBalance" style=display:block></h2>

<div onclick="deposit()">Deposit </div>

<div id="depositSection" style=display:none>
<form action="CustomerOperationsServlet?operation=deposit" onsubmit="return validateCreditAmount()" method="post">
Enter Amount :<input type="number" id="creditamount" name="creditamount" placeholder="enter amount" onblur="validateCreditAmount()" /><br/>
<br/><input type=submit value=deposit /> &nbsp;&nbsp;<input type="reset"  value="clear" class="reset"><br/>
<font color='red'><h6 id="amount_error_deposit"></h6></font>
</form>
</div>

<div onclick="withdraw()">Withdraw </div>

<div id="withdrawSection" style=display:none>
<form action="CustomerOperationsServlet?operation=withdraw" onsubmit="return validateDebitAmount()" method="post">
Enter Amount :<input type="number" id="debitamount" name="debitamount" placeholder="enter amount" onblur="validateDebitAmount()" /><br/>
<br/><input type=submit value=withdraw /> &nbsp;&nbsp;<input type="reset"  value="clear" class="reset"><br/>
<font color='red'><h6 id="amount_error_withdraw"></h6></font>
</form>
</div>

<div onclick="transfer()">Transfer </div>

<div id="transferSection" style=display:none>
<form action="CustomerOperationsServlet?operation=transfer" onsubmit="return validateTransferAmount()" method="post">
Enter Account Number<input type="number" id="accountNumber" name="accountNumber" placeholder="enter account number to transfer" onblur="validateTransferAmount()" /><br/><br/>
<font color='red'><h6 id="accountNumber_error"></h6></font>
Enter Amount :<input type="number" id="transferamount" name="transferamount" placeholder="enter amount" onblur="validateTransferAmount()" /><br/>
<br/><input type=submit value=transfer /> &nbsp;&nbsp;<input type="reset"  value="clear" class="reset"><br/>
<font color='red'><h6 id="amount_error_transfer"></h6></font>
</form>
</div>

<form action="CustomerOperationsServlet?operation=logout" method="post">
<h1><input type="submit" value='Logout' /></h1>

</body>
</html>