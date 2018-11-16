<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>
	Welcome to admin dashboard
	
	Click <a href="logout">here</a> to logout.
	
	<br><br><br><br><br><br><br><br>
	Add an Employee
	<form action="addEmployee" method="POST">
		Name : <input name="name">
		E-Mail : <input type="email" name="email">
		Password : <input type="password" name="password">
		Phone No. : <input name="phoneNo">
		
		Sex : 
		<select name="sex">
  			<option value="Male">Male</option>
  			<option value="Female">Female</option>
		</select>
		
		Department : <input name="department">
		
		Designation : 
		<select name="designation">
  			<option value="Clerk">Clerk</option>
  			<option value="AssistantManager">AssistantManager</option>
  			<option value="Manager">Manager</option>
		</select>
		
		Manager ID : <input name="managerId">
		Leave Balance : <input name="leaveBalance">
		
		<input type="submit" name="submit" value="Add Employee">
	</form>
	
	
	<br><br><br><br><br><br><br><br>
	Update Employee Details:<br><br>
	Enter employee's email id to search
	<form action="updateEmployee" method="POST">
		E mail : <input type="email" name="email">
		<input type="submit" value="search"> 
	</form>
</body>
</html>