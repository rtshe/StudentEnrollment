<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">------------Reset Password--------------</h2>
	<br>
	<br> ${msg}
	<br>
	<form action='ResetPassServlet' method='post'>
		<table align="center">
			<tr>
				<td>Username</td>
				<td>${un}</td>
			</tr>
			<tr>
				<td>Old Password</td>
				<td><input type='password' name='oldpass' /></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input type='password' name='newpass' /></td>
			</tr>
			<tr>
				<td>ReEnter Password</td>
				<td><input type='password' name='renewpass' /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type='submit' name='RESET' /></td>
			</tr>
			<tr>
				<td><input type='password' name='cpass' /></td>
			</tr>
			<tr>
			<td><input type = 'text' name = 'uname'/></td>
			</tr>  	
		</table>

	</form>
</body>
</html>