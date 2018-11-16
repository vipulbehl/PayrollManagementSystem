<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<c:if test="${param.act eq 'lo'}">
<p class="success">Logout Successfull! Thanks !</p>
</c:if>
	<form action="login" method="POST">
		Email : <input type="email" name="email"> <br>
		Password : <input type="password" name="password">
		<input type="submit" value="login">
	</form>
</body>
</html>