<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 Hello Web Gradle
 	Hello World JSP
	
	<p>
		<strong>
		
			<!-- jsp implicit object - Vado a scrivere il contesto (contexst root) dell'URL, ovvero /11.070AboutJSP   -->
			<%= pageContext.getServletContext().getContextPath() %>
		</strong>
	</p>
</body>
</html>