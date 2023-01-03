<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sba.wells.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kits</title>
</head>
<body>
<% Product Update = (Product)request.getAttribute("Update"); %>
<form action ="updateproduct?icode=<%=Update.getItem_no()%>" method="post">
<Label>Item Number:</Label>
<label><%=Update.getItem_no()%></label> 
<Label>Item Name:</Label>
<input type="text" id="" name="item_name" value ="<%=Update.getItem_name()%>"> 
<Label>Item Cost per product:</Label>
<input type="text" id=" " name="item_cost" value ="<%=Update.getItem_cost()%>"> 
<Label>Item Quantity:</Label>
<input type="text" id=" " name="item_quantity" value ="<%=Update.getItem_quantity()%>"> 

<input type="submit" id=" " value="UPDATE PRODUCT" > 
</form>
</body>
</html>