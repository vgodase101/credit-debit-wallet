<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1 style="background-color:red;">Credit Money Safely</h1>
<form action="./updateservlet" method="post">
Enter credit amount:<input type="number" name="amount"><br><br>
Enter accountnumber:<input type="number" name="accountnumber"><br><br>
<input type="submit" value="Credit"><br><br>

</form>

<form action="Main.jsp">
<input type="submit" value="Back to Home page">
</form>
</center>
</body>
</html>