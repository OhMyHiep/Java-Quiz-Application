<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<jsp:include page="navBar.jsp" /> 
</head>

<body>
	<h1>Registration</h1>
	 
	${Error} 
	<form:form action ="/user/register" method ="post" modelAttribute="user">
		<input type = "text" name = "username" placeholder="username"/>
		<input type = "password" name = "password" placeholder="Password"/>
		<input type = "password" name = "conPassword" placeholder="Confirm Password"/>
		<input type = "text" name ="firstName" placeholder="First Name"/>
		<input type = "text" name ="lastName" placeholder="Last Name"/>
		<input type ="hidden" name ="role" />
		<input type = "text" name ="email" placeholder="email"/>
		<input type = "submit" value = "register"/>
	</form:form>
	
</body>
</html>

