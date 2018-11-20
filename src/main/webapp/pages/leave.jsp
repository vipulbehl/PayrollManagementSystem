<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Core CSS - Include with every page -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<!-- Page-Level Plugin CSS - Forms -->

<!-- SB Admin CSS - Include with every page -->
<link href="css/sb-admin.css" rel="stylesheet">

<title>Leave Apply</title>
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
				<a class="navbar-brand" href="EmployeeDashboard">Dashboard</a>
			</div>
		
			<!-- Right Navigation Buttons-->
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
					</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="EmployeeDashboard"><i class="fa fa-user fa-fw"></i>Dashboard</a>
								</li>
								
								<li class="divider"></li>
								<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
								</li>
							</ul>
						</li>
					</ul>
				</nav>
			</div>

	<center><h3>Apply For Leave</h3></center>
	<form action="leave" method="POST" style="text-align:center">
		<center>
		<table style="text-align:center;width: 40%">
			<tr><td style="padding-bottom:10px"><input type="date" name="startDate"class="form-control" placeholder="Start Date"></td></tr>
			<tr><td style="padding-bottom:10px"><input type="date" name="endDate"class="form-control" placeholder="End Date"></td></tr>
			<tr><td><input type="submit" name="submit" value="Apply"  class="btn btn-primary"></td></tr>
		</table>
	</center>
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