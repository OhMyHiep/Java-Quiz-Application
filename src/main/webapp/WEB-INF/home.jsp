<%@page import="com.beaconfire.personalProject.domain.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
	<link rel="stylesheet" href="Feedback.css" >
	<jsp:include page="navBar.jsp" /> 
</head>
<body>
 
     <a href="/user/quiz">
        <input type="button" value="Load Quiz Categories"></input>
    </a>
  
  <div class="test">
  
  </div>
  
    <form:form action="/user/quiz/category" method="GET" modelAttribute="cat">
	  <input list="categories" name="categoryName">
	  <datalist id="categories">
	     <c:forEach var ="ctgry" items="${cat}" >
         	<option id="${ctgry.category_id}" value="${ctgry.categoryName}">
   		 </c:forEach>
	  </datalist>
	  <input type="submit" value="Choose ">
	</form:form>
     
  
     
     
     
     
     
     
     
     
	
</body>
</html>