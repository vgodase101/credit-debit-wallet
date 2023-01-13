<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image:url('payment.jpg');">

<center>
<h1 style="background-color:ORANGE;">Welcome :<%out.println(session.getAttribute("nm")); %></h1>
<h1 style="background-color:red;">Welcome to credit/debit wallet</h1>
<form action="Home.jsp" method="post">
<input type="submit" value="Credit"><br><br>
</form>
<form action="Withdrawl.jsp" method="post">
<input type="submit" value="Debit"><BR><bR>
</form>
<form action="Checkbalance.jsp" method="post">
<input type="submit" value="Check Balance"><br><br>
</form>
<form action="Transaction1.jsp" method="post">
<input type="submit" value="History of transaction"><br><br>
</form>

</center>
</body>
</html>