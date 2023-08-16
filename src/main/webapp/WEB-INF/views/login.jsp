<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login page</h1>
 <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
	Username : <input type="text" name="username">
	Password : <input type="text" name="password">
	<button type="submit">Login</button>
 </form>

</body>
</html>