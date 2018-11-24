<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Core CSS - Include with every page -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<!-- Page-Level Plugin CSS - Forms -->

<!-- SB Admin CSS - Include with every page -->
<link href="css/sb-admin.css" rel="stylesheet">

<title>Payslip</title>
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
							<a class="navbar-brand" href="EmployeeDashboard">Salary Slip</a>
					</div>
		
					<!-- Right Navigation Buttons-->
					<ul class="nav navbar-top-links navbar-right">
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="EmployeeDashboard"><i class="fa fa-user fa-fw"></i> Dashboard</a>
								</li>
								
								<li class="divider"></li>
								<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
								</li>
							</ul>
						</li>
					</ul>
				</nav>
            </div>
		<center>
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						Payslip
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Name</th>
										<th>Month</th>
										<th>Year</th>
										<th>Basic</th>
										<th>HRA</th>
										<th>DA</th>
										<th>TA</th>
										<th>PF</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${salary.employee.name}</td>
										<td>${salary.month}</td>
										<td>${salary.year}</td>
										<td>${salary.basic}</td>
										<td>${salary.hra}</td>
										<td>${salary.da}</td>
										<td>${salary.ta}</td>
										<td>${salary.pf}</td>
									</tr>
								</tbody>
							</table>
							<b>Total Salary : ${totalSalary}</b>
						</div>
					</div>
				</div>
			</div>
		</center>

        <!-- Core Scripts - Include with every page -->
		<script src="js/jquery-1.10.2.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	
		<!-- Page-Level Plugin Scripts - Forms -->
	
		<!-- SB Admin Scripts - Include with every page -->
		<script src="js/sb-admin.js"></script>
</body>
</html>