<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main menu</title>
</head>
<link href='https://fonts.googleapis.com/css?family=Architects Daughter' rel='stylesheet'>

<style>
body {
	text-align: center;
    font-family: 'Architects Daughter';font-size: 30px;
      background-color: #ccffb3;
}

.center {
   padding: 70px 0;
  text-align: center;
}
.button  {
  background-color:#008CBA;
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

.button1  {
  background-color: #009933;
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
a {
  color: white;
}
.button2:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}

div.b {
  position: absolute;
	right: 100px; 
  width: 100px;
  height: 120px;
  
} 
</style>
<body>
<div class ="b" >
<button class = button button2 type="submit">
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
LOGOUT
</spring-form:form>
</button>
</div>
<br>
<br>
<br>
<h1>Welcome to Corona Kit Dashboard!!!</h1>
<c:set var="user" value="${unm}" scope="session" />
		<c:choose>
			<c:when test="${unm!=null && role=='ADMIN'}">
			<button class="button1 button2">
				<a href="${pageContext.request.contextPath}/admin/home">ADMIN DASHBOARD</a>
				</button>
			</c:when>
			<c:when test="${unm!=null && role=='USER'}">
			<button class="button1 button2">
				<a href="${pageContext.request.contextPath}/user/home">USER DASHBOARD</a>
				</button>
			</c:when>
			
		</c:choose>
		
 
</body>
</html>