<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div>
	  <a href="/user">
	        <input type="button" value="Home"></input>
	   </a>
	   
	   <a href="/user/add">
        <input type="button" value="Register Here"></input>
    	</a>
	    
	<c:choose>
		<c:when test="${user!=null}">
			 <a href="/user/logout"> 
		        <input type="button" value="Log Out"></input>
		    </a>
  		</c:when>
		<c:otherwise>
		 
			<a href="/user">
		        <input type="button" value="Login"></input>
		    </a>
  		</c:otherwise>
    </c:choose>
	   
	   <a href="/feedback">
        <input type="button" value="Feedback"></input>
    </a>  
	 </div>
