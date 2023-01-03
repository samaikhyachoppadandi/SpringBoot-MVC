<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CoronaKits</title>
</head>
<link href='https://fonts.googleapis.com/css?family=Architects Daughter' rel='stylesheet'>
<style>
body {
    font-family: 'Architects Daughter';font-size: 40px;
      background-color: #ccffb3;
}

.center {
   padding: 70px 0;
  text-align: center;
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
</style>
<body>
<div class="center">
 <h1>Welcome to CoronaKit Home</h1>
 
 <button class="button button2">
<a href="${pageContext.request.contextPath}/custom-login">LOGIN</a>
</button>
</div>



</body>
</html>