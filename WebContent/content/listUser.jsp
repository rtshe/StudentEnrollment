<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students List</title>
<link href="/StudentEnrollmentWithJDBC/assets/css/bootstrap-united.css"
	rel="stylesheet" />
</head>
<body>
	<script src="/StudentEnrollmentWithJDBC/jquery-1.8.3.js">
		
	</script>

	<script src="/StudentEnrollmentWithJDBC/bootstrap/js/bootstrap.js">
		
	</script>
	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-left">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/StudentEnrollmentWithJDBC">Home</a></li>
				<li><a href="content/signup.jsp">Signup</a></li>
				<li><a href="content/login.jsp">Login</a></li>
				<li class="active"><a href="content/listUser.jsp">List Of
						Students</a></li>
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
	<table border=1 class="table">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<thead>

						<tr>
							<th>StudentID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Date of Birth</th>
							<th>Email Address</th>
							<th>UserName</th>
							<th>Password</th>
							<th colspan="2">Action</th>
				</div>

			</div>
		</div>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">

				<tr>
					<td><c:out value="${student.studentId}" /></td>
					<td><c:out value="${student.firstName}" /></td>
					<td><c:out value="${student.lastName}" /></td>
					<td><fmt:formatDate pattern="yyyy-MMM-dd"
							value="${student.dateOfBirth}" /></td>
					<td><c:out value="${student.emailAddress}" /></td>


					<td><c:out value="${student.userName }" /></td>
					<td><c:out value="${student.password }" /></td>
					<td><a
						href="StudentController?action=edit&studentId=<c:out value="${student.studentId }"/>">Update</a></td>
					<td><a
						href="StudentController?action=delete&studentId=<c:out value="${student.studentId }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>