<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login (Personal Project)</title>
</head>
<body>
	
	${registered}
	${Error}
	<form action="/user/loggingIn" method="POST">
		<input type="text" name="username" placeholder="username"/>
		<input type="password" name="password" placeholder="password"/>
		<input type="submit" value="Login"/>
	</form> 
	 
	 
	   
	<a href="/user/add">
        <input type="button" value="Register Here"></input>
    </a>
    
  
</body>

</html>
