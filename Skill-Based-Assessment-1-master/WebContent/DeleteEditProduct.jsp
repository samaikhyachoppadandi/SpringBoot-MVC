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
<h1>ALL PRODUCTS </h1> 
      <table border ="1"> 
      <tr bgcolor="00FF7F"> 
          <th><b>Item Number</b></th> 
          <th><b>Item Name</b></th> 
          <th><b>Item Quantity</b></th> 
          <th><b>Item Cost</b></th>
          <th><b>Delete/Edit</b></th>
         </tr> 
         
          <% List<Product> product = (ArrayList<Product>)request.getAttribute("Dproducts"); 
        	for(Product p:product){%> 
        	<tr> 
                <td><%=p.getItem_no()%></td> 
                <td><%=p.getItem_name()%></td> 
                <td><%=p.getItem_quantity()%></td>
                 <td><%=p.getItem_cost()%></td>
                 <td> <a href="deleteById?icode=<%=p.getItem_no()%>">DELETE</a> <span>|</span>
						<a href="editproduct?icode=<%=p.getItem_no()%>">EDIT</a> </td>
            </tr> 
            <%}%> 
         </table>
</body>
</html>