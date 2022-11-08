<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Roaster</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Dorms</h1>
		<div>
			<a href="/dorms/new">Add new dorm</a> <a href="/students/new">Add
				new student</a>
		</div>
		<table class="table table-dark col-6">
			<thead>
				<tr>
					<td>Dorn</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="dorm" items="${dorms }">
				<tr>
					<td>${dorm.name }</td>
					<td><a href="/dorms/${dorm.id }">See students</a></td>
				</tr>
			</c:forEach>
				
			</tbody>
		</table>

	</div>
</body>
</html>