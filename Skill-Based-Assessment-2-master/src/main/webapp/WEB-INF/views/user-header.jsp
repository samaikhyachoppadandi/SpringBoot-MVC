<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<link href='https://fonts.googleapis.com/css?family=Architects Daughter' rel='stylesheet'>
<style>

header {
    font-family: 'Architects Daughter';font-size: 20px;
    }

.button {
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


.button2:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
div.b {
  position: absolute;
	right: 100px; 
  width: 100px;
  height: 120px;
  
} 
.center {
   padding: 10px 0;
  text-align: center;
}

ul {

  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  border: 1px solid #e7e7e7;
  background-color: #f3f3f3;
}

li {
  float: left;
}

li a {
  display: block;
  color: #666;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #ddd;
}

li a.active {
  color: white;
  background-color: #4CAF50;
}
</style>
<header>
<div class ="b" >
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<button class = "button button2" type="submit">LOGOUT</button>
</spring-form:form>
</div>
<div class="center">
<h1>User Dashboard</h1>
</div>
	<hr />
	<nav><ul>
<li>	<a class="active" href = "${pageContext.request.contextPath}/user/home"> Home</a> </li>
	<li><a href = "${pageContext.request.contextPath}/user/show-list"> Show All Items</a> </li>
	<li><a href = "${pageContext.request.contextPath}/user/show-kit">Cart</a> </li>
</ul></nav>
<hr>
</header>