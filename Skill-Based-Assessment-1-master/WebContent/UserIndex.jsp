<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sba.wells.entity.*"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kits</title>
</head>
<body>
<h1>Welcome <%=request.getAttribute("cuser") %></h1>
<form action = "showproducts?session=<%=request.getAttribute("cuser") %>" method = "post">
<input type ="submit" value = "VIEW ALL PRODUCTS">
</form>

<form action = "showkit" method="post">
<input type="submit" value =" MY CART">
</form>

<form action = "place order"></form>

<%List<Product> product  = (ArrayList<Product>)request.getAttribute("products"); 
if(product!=null)
{
%>
<jsp:include page="/UserListALLProducts.jsp"></jsp:include>
<%} 
String show = (String)request.getAttribute("showKit");
if(show =="showKit"){
%>
<jsp:include page="/MyCart.jsp"></jsp:include>
<%} %>
</body>
</html>