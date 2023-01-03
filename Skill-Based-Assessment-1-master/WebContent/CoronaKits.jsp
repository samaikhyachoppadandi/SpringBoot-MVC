<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CoronaKits</title>
</head>
<body>

<form action= "newuser" method="post">

<div>Admin login --><a href="AdminLogin.jsp">Click Here</a></div>
<h2><center> Corona Safety Kits</center></h2>
<div><label>New Customer:</label><br>
Enter Name:<input type ="text" name = "customer_name" required><br>
Enter email:<input type = "email" name = "email" required><br>
Enter Mobile: <input type ="number" name = "mobile" ><br>
<input type="submit" value = "Register"></div>
</form>
</body>
</html>