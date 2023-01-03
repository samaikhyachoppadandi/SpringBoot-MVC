<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="java.util.*"%>
   <%@page import="com.sba.wells.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Welcome <%=request.getAttribute("Admin") %></h2>
<jsp:include page ="navigation.jsp"/>

<DIV>

<form action="newproduct" method ="post">
<input type = "submit" name="newproduct" value= "ADD NEW PRODUCT"> 
</form>
<form action="deleteproduct" method="post">
<input type = "submit" name="deleteproduct" value = "DELETE/EDIT PRODUCT">
</form>

<form action="list" method="post">
<input type = "submit" name="list" value=" VIEW PRODUCTS"> 
</form>
</DIV>
<div>
<% List<Product> product = (ArrayList<Product>)request.getAttribute("products");
if(product!=null) 
{
%>
<jsp:include page ="/ListAllProducts.jsp"/>
<%}
String addPage = (String)request.getAttribute("addPage");
if(addPage=="addPage")
{
%>
<jsp:include page="/AddNewProduct.jsp"/>
<%}
List<Product> Dproduct = (ArrayList<Product>)request.getAttribute("Dproducts");
if(Dproduct!=null) 
{
%>
<jsp:include page ="/DeleteEditProduct.jsp"/>
<%} %>
<%
Product u = (Product)request.getAttribute("Update");
if(u!=null)
{
%>
<jsp:include page ="/UpdatePage.jsp"/>
<%} %>
</div>
</body>
</html>