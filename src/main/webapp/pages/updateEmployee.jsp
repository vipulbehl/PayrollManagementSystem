<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="POST">
		Name : <input name="name" value="${emp.name}">
		E-Mail : <input type="email" name="email" value="${emp.email}">
		Password : <input type="password" name="password" value="${emp.password}">
		Phone No. : <input name="phoneNo" value="${emp.phoneNo}">
		
		Sex : 
		<select name="sex">
  			<option value="Male">Male</option>
  			<option value="Female">Female</option>
		</select>
		
		Department : <input name="department" value="${emp.department}">
		
		Designation : 
		<select name="designation">
  			<option value="Clerk">Clerk</option>
  			<option value="AssistantManager">AssistantManager</option>
  			<option value="Manager">Manager</option>
		</select>
		
		Manager ID : <input name="managerId" value="${emp.managerId}">
		Leave Balance : <input name="leaveBalance" value="${emp.leaveBalance}">
		
		<input type="submit" name="submit" value="Update Employee">
	</form>
	
	<form action="addAttendance" method="POST">
		Month <input type="number" name="month">
		Year <input type="number" name="year">
		Days Worked <input type="number" name="daysWorked">
		<input type="submit" value="Add">
	</form>
	
</body>
</html>