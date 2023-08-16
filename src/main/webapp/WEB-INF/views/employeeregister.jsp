<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUP/SignIN</title>
<style type="text/css">
body{
    background-color: rgb(0, 204, 255);
}
.hor1{
 display: inline-block;
    margin-left: 420px;
    margin-right: 200px;
}
.hor2{
 display: inline-block;
}
</style>
</head>
<body>


	<div class="hor1">
	<h1>Register here !!!</h1>
	<form action="<%=request.getContextPath() %>/register" method="post">
	
	<table style="with: 80%">
	
	
	<tr>
	<td>First Name</td>
	<td><input type="text" name="firstname" /></td>
	</tr>
	
	<tr>
	<td>Last Name</td>
	<td><input type="text" name="lastname" /></td>
	</tr>
	
	<tr>
	<td>Username</td>
	<td><input type="text" name="username" /></td>
	</tr>
	
	<tr>
	<td>Password</td>
	<td><input type="text" name="password" /></td>
	</tr>
	
	<tr>
	<td>Address</td>
	<td><input type="text" name="address" /></td>
	</tr>
	
	<tr>
	<td>Contact</td>
	<td><input type="text" name="contact" /></td>
	</tr>
	</table>
	
	<input type="submit" value="Submit" />
	
	</form>
	
	</div>
	
	<div class="hor2">
	<h1>Already register !!!</h1>
	<form action="<%=request.getContextPath()%>/LoginServlet" method="get">
	<button type="submit">Login</button>
	<br><br><br><br><br><br><br><br>
	</form>
	</div>

</body>
</html>