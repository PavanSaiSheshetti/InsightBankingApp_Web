<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
				try{
					   FileInputStream fstream = new FileInputStream("InsighBankingAppLog.log");
					   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
					   String strLine;
					   /* read log line by line */
					   while ((strLine = br.readLine()) != null)   {
					     /* parse strLine to obtain what you want */%>
					   <%= strLine %> 
					 <%  }
					   fstream.close();
					} catch (Exception e) {
					     System.err.println("Error: " + e.getMessage());
					}%>
</body>
</html>