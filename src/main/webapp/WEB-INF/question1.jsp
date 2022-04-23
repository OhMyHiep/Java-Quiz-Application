<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Questions</title>
	<jsp:include page="navBar.jsp" /> 
</head>
<body> 
    
    <c:if test="${not empty qList}">
	<form:form action="/user/quiz/nav" method="POST" modelAttribute="cat">
		<h2>${qList.get(current-1).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(current-1).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(current-1).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.choice_id}" name="choice_id" value="${choice.choice_id}" checked="checked">
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(current-1).questionContent}">
					
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id" value="${choice.choice_id}">
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(current-1).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:out value="${current-1}"></c:out>
		<c:out value="${current-1 eq 0}"></c:out>
		
		<c:if test="${current-1==0}">
			<input type="submit" name="submit" value="next">
		</c:if>
		
		<c:if test="${current-1==9}">
			<input type="submit" name="submit" value="prev">
			<input type="submit" name="submit" value="Submit">
			${submitError}
		</c:if>
		
		<c:if test="${current-1>0 && current-1<9}">
			<input type="submit" name="submit" value="next">
			<input type="submit" name="submit" value="prev">
		</c:if>
	</form:form>
	</c:if>



</body>
</html>