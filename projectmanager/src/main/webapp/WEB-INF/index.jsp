<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
</head>
<body>
	<h1>Welcome!</h1>
	<h2>Join our growing community</h2>
	<div class="container">
		<form:form action="/register/" method="post" modelAttribute="newUser"
			class="form form-group border">
			<h2>Register</h2>
			<div>
				<form:errors path="userName"></form:errors>
				<form:label path="userName">User Name:</form:label>
				<form:input path="userName"></form:input>
			</div>
			<div>
				<form:errors path="email"></form:errors>
				<form:label path="email">Email:</form:label>
				<form:input type="email" path="email"></form:input>
			</div>
			<div>
				<form:errors path="password"></form:errors>
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password"></form:input>
			</div>
			<div>
				<form:errors path="confirm"></form:errors>
				<form:label path="confirm">Confirm Password:</form:label>
				<form:input type="password" path="confirm"></form:input>
			</div>
			<input type="submit" value="Register" />
		</form:form>
		<form:form action="/login" method="post" modelAttribute="newLogin"
			class="form form-group border p-3">
			<h2>Log In</h2>
			<div>
				<form:errors path="email"></form:errors>
				<form:label path="email">Email:</form:label>
				<form:input type="email" path="email"></form:input>
			</div>
			<div>
				<form:errors path="password"></form:errors>
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password"></form:input>
			</div>
			<input type="submit" value="Login" />
		</form:form>
	</div>
</body>
</html>