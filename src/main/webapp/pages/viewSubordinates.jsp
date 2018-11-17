<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subordinates</title>
</head>
<body>	
	<table border=1>
	<tr>
		<td>Name</td>
		<td>Sex</td>
		<td>Email</td>
		<td>Designation</td>
		<td>Department</td>
		<td>Leave Balance</td>
	</tr>
	<c:forEach items="${subordinates}" var="emp">
    	<tr>
    		<td>${emp.name}</td>
			<td>${emp.sex}</td>
			<td>${emp.email}</td>
			<td>${emp.designation}</td>
			<td>${emp.department}</td>
			<td>${emp.leaveBalance}</td>
    	</tr>
    </c:forEach>
    </table>
    
    <a href="dashboard"> Go Back</a>
    
</body>
</html>