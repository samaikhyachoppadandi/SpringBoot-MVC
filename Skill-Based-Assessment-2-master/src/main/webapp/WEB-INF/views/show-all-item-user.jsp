<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Items</title>
</head>
<style>
.container {
 margin: 10px 80px 15px
  width: 100%;
  padding: 10px;
}
table {
text-align:center;
  border-collapse: collapse;
  width: 60%;
   border: 1px solid #ddd;
}

th, td {
  text-align: center;
  padding: 5px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
padding:10px;
  background-color: #4CAF50;
  color: white;
  font-size: 20px;
}

a {
  color: white;
}

.button1 {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin: 2px 2px;
  cursor: pointer;
}

.button3 {
background-color: #008CBA;
border-radius: 12px;
} /* Blue */
.button4 {
background-color: #f44336;
border-radius: 12px;} /* Red */ 

h3{
font-family: 'Architects Daughter';
font-size:20px;
 text-align: center;
</style>

<body>
<jsp:include page="user-header.jsp" />
<h3>Items</h3>

	<%String username = (String)session.getAttribute("user");
	session.setAttribute("user",username);
	%>
	<div class="container">
	<c:choose>
		<c:when test="${products==null || products.isEmpty() }">
			<p>No Items Found</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Id</th>
					<th>product name</th>
					<th>cost</th>
					<th>description</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${products}" var="product">
					<tr>
					<td>${product.id }</td>
					<td>${product.productName}</td>
					<td>${product.cost }</td>
					<td>${product.productDescription}</td>

					<td>
					<button class= "button1 button3">	<a href="${pageContext.request.contextPath }/user/add-to-cart?id=${product.id}">ADD CART</a></button> 
		
					</td>
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>