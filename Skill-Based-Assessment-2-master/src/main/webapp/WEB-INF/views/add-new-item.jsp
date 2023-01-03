<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new item</title>
</head>
<style>
<link href='https://fonts.googleapis.com/css?family=Architects Daughter' rel='stylesheet'>
<style>
body {
    font-family: 'Architects Daughter';
    text-align: center; 
}

.container {
 margin: auto;
  width: 30%;
  padding: 10px;
  height: 400px;  

  border: 1px solid #ccc;
}
form {
text-align: center;
   box-sizing: border-box;
}
input[type=text], input[type=decimal], input[type=number]{
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

label{
font-family: 'Architects Daughter';
    display: inline-block;
    float: left;
    clear: left;
    width: 200px;
    text-align: justify;
    font-size: large;
}
input {
  display: inline-block;
  float: left;
  font-family: 'Architects Daughter';
}
h3{
font-family: 'Architects Daughter';
font-size:30px;
 text-align: center;
}
</style>
<body>

<jsp:include page="admin-header.jsp" />


<div class="container">

<h3>${isNew?"New Item":"Edit Item"}</h3>

<form:form action= '${isNew?pageContext.request.contextPath.concat("/admin/addItem"):pageContext.request.contextPath.concat("/admin/product-save") }' method="POST" modelAttribute="product">


		
			<form:label path="productName"><b>Product Name: </b> </form:label>
			<form:input type="text" path="productName" />
			<form:errors path="productName"/>
		<br>

			<form:label path="cost"><b>Cost Price: </b> </form:label>
			<form:input type="decimal" path="cost" />
			<form:errors path="cost"/>			
		<br>
			<form:label path="productDescription"><b>Product Description: </b> </form:label>
			<form:input type="text" path="productDescription" />
			<form:errors path="productDescription"/>		
	
		<br>
		<br>
		<button class = "button button2" type="submit">SAVE</button>	
			<br>
			<br>
	</form:form>

</div>
</body>
</html>