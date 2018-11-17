<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Transactions</title>
</head>
<body>
	This page displays your leave transactions
	<table border=1>
	<tr>
		<td>Leave Start Date</td>
		<td>Leave End Date</td>
		<td>Number of Leaves</td>
	</tr>
	<c:forEach items="${leaveT}" var="leave">
    	<tr>
    		<td>${leave.startDate}</td>
    		<td>${leave.endDate}</td>
    		<td>${leave.numberLeaves}</td>
    	</tr>
    </c:forEach>
    </table>
    
    <a href="dashboard"> Go Back</a>
</body>
</html>