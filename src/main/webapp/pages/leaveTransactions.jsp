<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>Leave Transactions</title>
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
							<a class="navbar-brand" href="EmployeeDashboard">Emloyee Leave Details</a>
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
	<br><br>

	<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					Leave Transactions
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Leave Start Date</th>
									<th>Leave End Date</th>
									<th>Number of Leaves</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${leaveT}" var="leave">
									<tr>
										<td>${leave.startDate}</td>
										<td>${leave.endDate}</td>
										<td>${leave.numberLeaves}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!-- Core Scripts - Include with every page -->
		<script src="js/jquery-1.10.2.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	
		<!-- Page-Level Plugin Scripts - Forms -->
	
		<!-- SB Admin Scripts - Include with every page -->
		<script src="js/sb-admin.js"></script>

</body>
</html>