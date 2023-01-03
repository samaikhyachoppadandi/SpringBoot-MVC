<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    <%@page import="com.sba.wells.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kits</title>
</head>
<body>
<h1>PRODUCTS IN THE CART </h1> 
      <table border ="1"> 
      <tr bgcolor="00FF7F"> 
          
          <th><b>Item Name</b></th> 
          <th><b>Item Cost</b></th>
           <th><b>Quantity</b></th>
          <th><b>Add Item to Cart</b></th>
         
         </tr> 
         <%String session_user = (String)request.getAttribute("cuser"); %>
          <% List<Cart> cart = (ArrayList<Cart>)request.getAttribute("MyCart"); 
        	for(Cart p:cart){
        		if(session_user == p.getUsername()){
        			Product p1 = p.getMyProducts();
        		%> 
        	<tr> 
        		<form action="deletitem?icode=<%=p1.getItem_no()%>" method ="post">
                <td><%=p1.getItem_name()%></td> 
                 <td><%=p1.getItem_cost()%></td>
                 <td><%=p1.getItem_quantity() %></td>
            	<td><input type="submit" value="DELETE"></td>
            </form>
            </tr> 
            <%}}%> 
         </table>
</body>
</html>