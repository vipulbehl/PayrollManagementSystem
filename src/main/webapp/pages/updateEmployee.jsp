<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Core CSS - Include with every page -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<!-- Page-Level Plugin CSS - Forms -->

<!-- SB Admin CSS - Include with every page -->
<link href="css/sb-admin.css" rel="stylesheet">

<title>Admin Dashboard</title>
</head>
<body>

<div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<!--Nav Header-->
			<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="adminDashboard">Admin Dashboard</a>
			</div>

			<!-- Right Navigation Buttons-->
			<ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="adminDashboard"><i class="fa fa-user fa-fw"></i> Dashboard</a>
						</li>
						
						<li class="divider"></li>
						<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
						</li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>

	<center><h3>Update Employee Details</h3></center>
	<form action="update" method="POST" style="text-align:center">
		<center>
		<table style="text-align:center;width: 40%">
			<tr><td style="padding-bottom:10px"><input name="name"class="form-control" placeholder="Name" value="${emp.name}"></td></tr>
			<tr><td style="padding-bottom:10px"><input type="email" name="email"class="form-control" placeholder="E-Mail" value="${emp.email}"></td></tr>
			<tr><td style="padding-bottom:10px"><input type="password" name="password"class="form-control" placeholder="Password" value="${emp.password}"></td></tr>
			<tr><td style="padding-bottom:10px"><input name="phoneNo" class="form-control" placeholder="Phone No." value="${emp.phoneNo}"></td></tr>
			<tr><td style="padding-bottom:10px">
				<select name="sex" class="form-control">
					<option value="Male">Male</option>
					<option value="Female">Female</option>
			  </select>
			</td></tr>
			<tr><td style="padding-bottom:10px"><input name="department"class="form-control" placeholder="Department" value="${emp.department}"></td></tr>
			<tr><td style="padding-bottom:10px">
				<select name="designation" class="form-control">
					<option value="Clerk">Clerk</option>
					<option value="AssistantManager">AssistantManager</option>
					<option value="Manager">Manager</option>
				</select>
			</td></tr>
			<tr><td style="padding-bottom:10px"><input name="managerId" class="form-control" placeholder="Manager Id" value="${emp.managerId}"></td></tr>
			<tr><td style="padding-bottom:10px"><input name="leaveBalance" class="form-control" placeholder="Leave Balance" value="${emp.leaveBalance}"></td></tr>
			<tr><td><input type="submit" name="submit" value="Update Employee"  class="btn btn-success"></td></tr>
		</table>
	</center>
	</form>

	

	<h3>Add Attendance</h3>
	<form action="addAttendance" method="POST">
		<table>
			<tr>
				<td style="padding-right:10px"><input type="number" name="month" class="form-control" placeholder="Month"></td>
				<td style="padding-right:10px"><input type="number" name="year" class="form-control" placeholder="Year"></td>
				<td style="padding-right:10px"><input type="number" name="daysWorked" class="form-control" placeholder="Days Worked"></td>
				<td style="padding-right:10px"><input type="submit" value="Add" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	

	<!-- Core Scripts - Include with every page -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Page-Level Plugin Scripts - Forms -->

    <!-- SB Admin Scripts - Include with every page -->
	<script src="js/sb-admin.js"></script>

</body>
</html>