<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
	<jsp:include page="navBar.jsp" /> 
</head>
<body>
	
	<h3> First Name:${user.firstName}    Last Name:${user.lastName} </h3>  
	 
	<h3>${quizName} </h3>
	<h4> start time:${begin} End Time:${end}</h4> 
	<c:choose>
		<c:when test="${score>=6}">	
			<h4> you pass with a score of ${score}</h4>
  		</c:when>
		<c:otherwise>  		
				<h4> you failed with a score of ${score}</h4>
		</c:otherwise>
	</c:choose>
<a href="/user/quiz"> <input type="button" value="take another quiz"></a>
	<h2>${qList.get(0).questionContent}?</h2>
	
		<c:forEach var="choice" items="${qList.get(0).choices}">
		 
			<c:set var="key" scope="session" value="${qList.get(0).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id1" value="${choice.choice_id}" disabled checked="checked">
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id1" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		
		<h2>${qList.get(1).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(1).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(1).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id2" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(1).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id2" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(1).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<h2>${qList.get(2).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(2).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(2).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id3" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(2).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id3" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(2).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		<h2>${qList.get(3).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(3).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(3).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id4" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(3).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id4" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(3).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		
		
		<h2>${qList.get(4).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(4).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(4).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id5" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(4).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id5" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(4).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		<h2>${qList.get(5).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(5).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(5).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id6" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(5).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id6" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(5).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		<h2>${qList.get(6).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(6).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(6).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id7" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(6).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id7" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(6).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		
		<h2>${qList.get(7).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(7).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(7).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id8" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(7).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id8" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(7).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		
		<h2>${qList.get(8).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(8).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(8).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id9" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(8).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id9" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(8).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		<h2>${qList.get(9).questionContent}?</h2>
		<c:forEach var="choice" items="${qList.get(9).choices}">
		
			<c:set var="key" scope="session" value="${qList.get(9).questionContent}"/> 
			<c:set var="value" scope="session" value="${choice.choice_id}"/> 
			<%-- <c:out value="${map[key]}"/>  --%>
			<c:choose>
				<c:when test="${map[key] eq value}">
					<input type="radio" id="${choice.isCorrect}" name="choice_id10" value="${choice.choice_id}" checked="checked" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(9).questionContent}">
					<%-- <input type="hidden" name="${choice.choice_id}" value="${qList.get(0).questionContent}" > --%>
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${choice.choice_id}" name="choice_id10" value="${choice.choice_id}" disabled>
					<label for="${choice.choice_id}">"${choice.choiceContent}"</label> 
					<input type="hidden" name="${choice.choice_id}" value="${qList.get(9).questionContent}">
  				</c:otherwise>
			</c:choose>
		</c:forEach>
	 	

</body>
</html>