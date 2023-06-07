<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creating a form - Servlet</title>

<style>
form {
	border: 1px solid gray;
	width: 250px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 200px;
	padding: 30px;
	display: grid;
	grid-template-columns: 1fr 1fr;
	grid-gap: 0.5em 0.5em;
}

#submit {
	grid-column: 2/3;
}

label {
	justify-self: right; 
}

</style>

</head>
<body>

	<p>
		<c:out value="${pageContext.servletContext.contextPath}" />
	</p>
	
	<p>
		<c:url value="/test" />
	</p>
	
	<form>
		<label for="name">Name:</label> 
		<input type="text" id="name" name="name" />
		
		<label for="password">Password:</label> 
		<input type="password" id="password" name="password" />
		
		<input id="submit" type="submit" value="Submit" />
	</form>
</body>
</html>