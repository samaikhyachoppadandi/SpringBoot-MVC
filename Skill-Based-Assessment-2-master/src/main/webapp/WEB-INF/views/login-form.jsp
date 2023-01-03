<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring-form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-form</title>
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
<core:if test="${param.error != null}">
	<i>Invalid Credentials!!!</i>
</core:if>
<h1>LOGIN IN</h1>
<div class="container">
<spring-form:form action="${pageContext.request.contextPath}/login" method="POST">
	<br/>
	<br/>
	<label><b>Username  : </b></label>
	<input type="text" placeholder="Enter Username"name="unm" required/>
	<br/>
	<br/>
	<label><b>Password  : </b> </label>
	<input type="password" placeholder="Enter Password" name="pwd" required/>
	<br/>
	<br/>
	 <button class="button button2" type="submit">
	LOGIN
	</button>
</spring-form:form>
</div>
<br>
<div style="background-color:#f1f1f1">
New User?  <a href = "${pageContext.request.contextPath}/register">Register Here</a>
</div>
<core:if test="${param.logout != null}">

	<i>You have been logged out successfully!!!</i>
</core:if>
<c:if test="${msg != null}">
			<p><strong>${msg }</strong>
		</c:if>
</body>
</html>