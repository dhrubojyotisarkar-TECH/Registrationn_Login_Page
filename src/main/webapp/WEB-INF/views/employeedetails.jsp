<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>you are successfully registered !!</h1>
			<form action="<%=request.getContextPath()%>/LoginServlet" method="get">
			<button type="submit">Login</button>
			</form>
</body>
</html>