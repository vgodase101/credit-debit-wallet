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
<form action="./createaccountservlet" method="post">
Enter username:<input type="text" name="username"><br><br>
Enter password:<input type="text" name="password"><br><br>
Enter name:<input type="text" name="name"><br><br>
Enter age:<input type="number" name="age"><br><br>
Enter Defaultamount:<input type="number" name="amt"><br><br>
<input type="submit" value="create account">
</center>
</form>
</body>
</html>