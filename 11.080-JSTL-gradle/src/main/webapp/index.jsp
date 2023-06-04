<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello World JSP
	
	<p>
		<strong>
		
			<!-- jsp implicit object - Vado a scrivere il contesto (contexst root) dell'URL, ovvero /11.070AboutJSP   -->
			<%= pageContext.getServletContext().getContextPath() %>
		</strong>
	</p>
	
	<p>
		<strong>
	<!-- JSTL Expression Language  -->
	${pageContext.servletContext.contextPath} 
		</strong>
	</p>
</body>
</html>