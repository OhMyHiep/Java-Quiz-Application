<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Quiz-View</title>
</head>
	<style>
		table, th, td {
		  border:1px solid black;
		}
	</style>
<body>
	

	<table class="tg">
		<thead>
		  <tr>
		    <th class="tg-ul38">name</th>
		    <th class="tg-ul38">No. of Questions</th>
		    <th class="tg-ul38">Category</th>
		    <th class="tg-ul38">Date Taken</th>
		     <th class="tg-ul38"> Score</th>
		  </tr>
		</thead>
		<tbody>
		<c:forEach var="s" items="${subList}">
			<tr>
		    <td class="tg-0lax">${s.firstName} ${s.lastName}</td> 
		    <td class="tg-0lax"> <%-- ${s.nbrQuizQuestion} --%></td>
		    <td class="tg-0lax">${s.category}</td>
		    <td class="tg-0lax">${s.startTime}</td>
		    <td class="tg-0lax">${s.score}</td> 
		    
		    <td class="tg-0lax">
		    	<a href="/user/quiz/id/${s.quiz_id}">
					<input type="button" name="detailedQuiz" value="View Quiz">
				</a>
		    </td> 
		  </tr>
		 
		</c:forEach>
		  
		</tbody>
	</table>

	


</body>
</html>