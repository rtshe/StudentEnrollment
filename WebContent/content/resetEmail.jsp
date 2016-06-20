<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Enrollment Signup</title>
<link href="/StudentEnrollmentWithJDBC/bootstrap/css/bootstrap.css"
	rel="stylesheet" />
<link href="/StudentEnrollmentWithJDBC/datepicker/css/datepicker.css"
	rel="stylesheet" />
<link href="/StudentEnrollmentWithJDBC/assets/css/bootstrap-united.css"
	rel="stylesheet" />

<style>
.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/StudentEnrollmentWithJDBC">Home</a></li>
				<li><a href="signup.jsp">Signup</a></li>
				<li class="active"><a href="update.jsp">Update</a></li>
				<li><a href="login.jsp">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Explore<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Contact us</a></li>
						<li class="divider"></li>
						<li><a href="#">Further Actions</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>

	<script src="/StudentEnrollmentWithJDBC/jquery-1.8.3.js">
		
	</script>

	<script src="/StudentEnrollmentWithJDBC/bootstrap/js/bootstrap.js">
		
	</script>

	<script
		src="/StudentEnrollmentWithJDBC/datepicker/js/bootstrap-datepicker.js">
		
	</script>


	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>Forgot Your Password</h1>
				<p>Do not worry, Be patient!</p>
			</div>
		</div>

		<div></div>
	</div>


	<form method="post" action="./Send">
		<%
			if (request.getAttribute("linkfailuremsg") != null) {
		%>
		<font color="black" size="4"><p align="center"
				style="background-color: lightyellow">
				This link has been accessed once already.<br> OR it has been
				more than 1 hour since you requested for it.<br> In case you
				are trying to reset your password again, request for new link below.
			</p></font>
		<%
			}
		%>
		<table class="tablelayout">
			<caption>Reset your Password</caption>
			<tr>
				<td class="required">Enter your Email id</td>
				<td><input type="text" name="cus_email" id="cus_email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="reset"
					onclick="javascript: return Verify()" /></td>
			</tr>
		</table>
	</form>




</body>
</html>