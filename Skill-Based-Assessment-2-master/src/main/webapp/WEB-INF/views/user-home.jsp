<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<link href='https://fonts.googleapis.com/css?family=Architects Daughter' rel='stylesheet'>
<style>
body {
    font-family: 'Architects Daughter';font-size: 40px;
}
</style>
<body>
<jsp:include page="user-header.jsp" />
<div class = "center">
Hello!
<% out.print(session.getAttribute("user"));%>
</div>
<c:if test="${msg != null}">
			<p><strong>${msg }</strong>
		</c:if>
<hr/>
</body>
</html>