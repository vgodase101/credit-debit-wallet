<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<%ResultSet rs=(ResultSet)session.getAttribute("rs"); %>
<body>
<center>
<table border="2" cellspacing="20" cellpadding="10">
<tr>
<th>
Transaction History
</th>
</tr>
<%
String transaction="";
while(rs.next())
{
	 transaction=rs.getString("transaction");

%>

<tr>
<td>
<%out.println(transaction); %>
</td>
</tr>
<%} %>






</table>
<br><br>
<form action="Main.jsp" >
<input type="submit" value="Back to Home page">
</form>
</center>
</body>
</html>