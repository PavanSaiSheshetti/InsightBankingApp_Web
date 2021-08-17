<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="CSS/styles.css" />
<script type="text/javascript" src="JS/validateCustomer.js" ></script>
<title>Insert title here</title>
</head>
<body>

<form class="registerFrom" action='RegisterServlet' onsubmit="return validateCustomer()" method="post">
<h1> Register Account Section</h1>
<table cellpadding=10 cellspacing=10 method="doPost" class="registerTable">
<tr><td> First Name : </td>
<td> <input type="text" id="firstName" class="firstName" name="firstName" placeholder="enter you firstname" onblur="validateCustomer()"></td><td><h6 id="firstName_error"></h6></td></tr><br/>
<tr><td> Last Name : </td> 
<td> <input type="text" id="lastName" class="lastName" name="lastName" placeholder="enter suurname" onblur="validateCustomer()"></td><td><h6 id="lastName_error"></h6></td> </tr><br/>
<tr><td> User Name : </td>
<td> <input type="text" id="userName" class="userName" name="userName" placeholder="choose username" onblur="validateCustomer()"></td><td><h6 id="userName_error"></h6></td></tr><br/>
<tr><td> Password : </td> 
<td> <input type="text" id="password" class="password" name="password" placeholder="choose strong password " onblur="validateCustomer()"></td><td><h6 id="password_error"></h6></td></tr><br/>
<tr><td> Re-Enter Password : </td> 
<td> <input type="text" id="rePassword" class="rePassword" name="rePassword" placeholder="reenter password" onblur="validateCustomer()"></td><td><h6 id="rePassword_error"></h6></td></tr><br/>
<tr><td> Opening Deposit : </td> 
<td> <input type="number" id="openingDeposit" class="openingDeposit" name="openingDeposit" placeholder="enter amount" onblur="validateCustomer()"></td><td><h6 id="openingDeposit_error"></h6></td></tr><br/>
<tr><td> <input type="submit"  value="Register" class="submit"></td></tr><br/>
</table>
<h3 class="login">already have an account! please <a href="CustomerLogin.jsp">Login</a></h3>
</form>
</body>
</html>