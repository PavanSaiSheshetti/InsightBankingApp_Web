<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="CSS/styles.css"/>
<script type="text/javascript" src="JS/validateUserLogin.js" > </script>
</head>
<body>

<h1>Customer Login Page</h1>

<form action="LoginServlet?type=customer" onsubmit="return validate() " method="post">
<table cellpadding=10 cellspacing=10>
<tr><td>UserName : </td><td><input type=text name="userName" id='userName' class='userName' placeholder="enter username" onblur="validate()"/></td><td><h6 id="userName_error"></h6></td></tr>
<tr><td>Password : </td><td><input type=text/ name="password" id='password' class='password' placeholder="enter password" onblur="validate()"/></td><td><h6 id="password_error"></h6></td></tr>
<tr><td><input type=submit value='Login' ></td><td>
<input type=reset value='Clear'></td></tr>
</table>
</form>
</body>
</html>