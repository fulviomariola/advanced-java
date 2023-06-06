<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<c:out value="Hello World JSTL" />
 
	<p>
		<strong>
			<!-- jsp implicit object - Vado a scrivere il contesto (contexst root) dell'URL, ovvero /11.070AboutJSP   -->
			<%= new java.util.Date() %>
		</strong>
	</p>
	
	<p>
		<strong>
			<!-- jsp implicit object - Vado a scrivere il contesto (contexst root) dell'URL, ovvero /11.070AboutJSP   -->
			<%= pageContext.getServletContext().getContextPath() %>
		< /strong>
	</p>
	<p>
		<strong>
			${pageContext.servletContext.contextPath}	
		</strong>
	</p>
</body>
</html>