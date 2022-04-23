<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback</title>
	<jsp:include page="navBar.jsp" /> 
	<link rel="stylesheet" href="Feedback.css" >
</head>
<body> 
	 <form class="test" action="/feedback" method="POST">
	 <div class="test">
		 <div class="rating"> 
		  <label>
		    <input type="radio" name="stars" value="1" />
		    <span class="icon">★</span>
		  </label>
		  <label>
		    <input type="radio" name="stars" value="2" />
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		  </label>
		  <label>
		    <input type="radio" name="stars" value="3" />
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		    <span class="icon">★</span>   
		  </label>
		  <label>
		    <input type="radio" name="stars" value="4" />
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		  </label>
		  <label>
		    <input type="radio" name="stars" value="5" />
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		    <span class="icon">★</span>
		  </label>
	  </div>
     	 <input width="200" height="100" type="text" name="feedback">
	 <input type="submit" value="Submit Feedback">
	</div>
	</form>

</body>
</html>