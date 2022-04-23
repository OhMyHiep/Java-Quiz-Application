<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Admin's User-View</title>
</head>

	<style>
		table, th, td {
		  border:1px solid black;
		}
	</style>
<body>

<%-- 	<form:form action="/user/submission/id" method="GET" modelAttribute="user">
	  <input list="users" name="user_id">
	  <datalist id="users">
	     <c:forEach var ="id" items="${cat}" >
         	<option id="" value="">
   		 </c:forEach>
	  </datalist>
	  <input type="submit" value="Choose ">
	</form:form> --%>
     
     <table class="tg">
		<thead>
		  <tr>
		    <th class="tg-ul38">First Name</th>
		    <th class="tg-ul38">Last Name</th>
		    <th class="tg-ul38">Quiz</th>
		    <th class="tg-ul38">Address</th>
		    <th class="tg-ul38">Email</th>
		    <th class="tg-ul38"> Phone#</th>
		    <th class="tg-ul38"> Status</th>
		  </tr>
		</thead>
		<tbody> 
	
		 <c:forEach var ="u" items="${userList}" varStatus="idx">
         	<tr>
		    <td class="tg-0lax">${u.firstName}</td>
		    <td class="tg-0lax">${u.lastName}</td>
		    
		    <td class="tg-ul38">
		    	<a href="/user/submission/id/${u.user_id}">
					<input type="button" id="status" name="status" value="View Submissions">
				</a>
		    </td>
		    
		    <td class="tg-0lax">${u.address}</td>
		    <td class="tg-0lax">${u.email}</td>
		    <td class="tg-0lax">${u.phoneNum}</td>
		    <td class="tg-0lax">${u.status}</td>
			<c:choose>
				<c:when test="${u.status eq 'suspended'}">
					<td class="tg-0lax">
				    	<a href="/user/status/idx/${idx.index}">
					        <input type="button" id="status" name="status" value="activate">
					    </a>
		    		</td>
  				</c:when>
				 <c:otherwise>
					 <td class="tg-0lax">
				    	<a href="/user/status/idx/${idx.index}">
					        <input type="button" name="status" value="suspend">
					    </a>
		    		</td>
  				</c:otherwise>
			</c:choose>	 
		  </tr>
   		 </c:forEach>
		</tbody>
	</table>
     
     
     
</body>







</html>