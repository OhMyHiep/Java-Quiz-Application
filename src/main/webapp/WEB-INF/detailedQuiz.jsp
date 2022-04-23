<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detailed Quiz View</title>
</head>

<style>
#yes{
	color:green;
}

#no{
	color:red;
}
</style>
<body>
		<c:forEach var="qq" items="${quiz.quizQuestions}">
			<h2>${qq.question.questionContent}</h2>
		
			<c:forEach var="c" items="${qq.question.choices}">
					<c:choose>
				<c:when test="${c eq qq.choice}">
					<input type="radio" id="${c.isCorrect}" value="${c.choice_id}" disabled checked="checked">
					<label for="${c.isCorrect}" id="${c.isCorrect}">"${c.choiceContent}"</label> 
  				</c:when>
				 <c:otherwise>
					 <input type="radio" id="${c.isCorrect}" value="${c.choice_id}" disabled>
					<label for="${c.isCorrect}" id="${c.isCorrect}">"${c.choiceContent}"</label> 
  				</c:otherwise>
			</c:choose>
			</c:forEach>
		</c:forEach>
		
</body>
</html>