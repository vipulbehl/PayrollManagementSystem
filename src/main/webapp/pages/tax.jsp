<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tax Page</title>
</head>
<body>
<c:if test="${param.act eq 'lo'}">
<p class="success">Logout Successfull! Thanks !</p>
</c:if>

Click 
	
	<a href="logout"> here </a> 
	
	to logout.
	
	<br><br>

 Your Annual Salary is : ${annualSalary}
 <br><br><br>
 
 Your Annual Tax Amount is : ${totalTax}
 <br><br><br>
 
 Your  Salary left after tax deduction is : ${salaryLeft}
 <br><br><br>
 
 Your Social Status is : ${status}
 
</body>
</html>