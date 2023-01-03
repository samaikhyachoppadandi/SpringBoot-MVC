<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<link href='https://fonts.googleapis.com/css?family=Architects Daughter' rel='stylesheet'>
<style>
body {
    font-family: 'Architects Daughter';font-size: 20px;
    text-align: center;
     
}

.container {
 margin: auto;
  width: 20%;
  padding: 10px;
  height: 300px;  
  padding: 50px;
  border: 1px solid #ccc;
}
form {
text-align: center;
   box-sizing: border-box;
}
input[type=text], input[type=password] {
 
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
label{

    display: inline-block;
    width: 200px;
    text-align: justify;
    
}
.button {
  background-color:#4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
}


.button2:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
  
  
}
</style>
<body>
	<h2>New User Registration</h2>
	<hr/>
	
	<spring:form action="${pageContext.request.contextPath}/register-save" method="POST" modelAttribute="user">
		<br/>
		<br/>
		<spring:label path="username"><b>Username:</b></spring:label>
		<spring:input path="username" placeholder="Enter User name"/>
		<br/>
		<br/>
		<spring:label path="password"><b>Password:</b></spring:label>
		<spring:password  path="password" placeholder="Enter Passowrd"/>
		<br/>
		<br/>
		<spring:label path="email"><b>Email:</b></spring:label>
		<spring:input path="email" placeholder="Enter Email"/>
		<br/>
		<br/>
		<spring:label path="contact"><b>Contact No.:</b></spring:label>
		<spring:input path="contact" placeholder="Enter Contact No"/>
		<br/>
		<br/>
		<button class = "button button2" type="submit">
		REGISTER
		</button>
	</spring:form>
	
</body>
</html>