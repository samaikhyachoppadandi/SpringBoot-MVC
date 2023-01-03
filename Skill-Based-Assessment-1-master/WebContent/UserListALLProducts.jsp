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
 <br>
<% String msg = (String)request.getAttribute("MSG");
	String product_name = (String)request.getAttribute("item_name");
				if(msg!=null && product_name!=null){
				%> <h3>Ypur product <%= product_name %> was added to cart</h3>
			<% } %>	
					
      <table border ="1"> 
      <tr bgcolor="00FF7F"> 
          
          <th><b>Item Name</b></th> 
          <th><b>Item Cost</b></th>
           <th><b>Quantity</b></th>
          <th><b>Add Item to Cart</b></th>
         
         </tr> 
         <%request.getAttribute("cuser"); %>
          <% List<Product> product = (ArrayList<Product>)request.getAttribute("products"); 
        	for(Product p:product){%> 
        
        	<tr> 
        		<form action = "addnewitem?icode=<%=p.getItem_no()%>" method ="post">
                <td><%=p.getItem_name()%></td> 
                 <td><%=p.getItem_cost()%></td>
                 <td><input type="number" name = "quantity"></td>
            	<td><input type="submit" value="ADD TO CART"></td>
            </form>
            </tr> 
            <%}%> 
         </table>
</body>
</html>