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
		<h1>${dorm.name }</h1>
		<a href="/dorms">Dashboard</a>
		<form action="/dorms/addstudent" method="post"
			 class="form form-group border">
			 <input name="dorm_id" type="hidden" value="${dorm.id }">
			<select name="student_id">
				<c:forEach var="student" items="${allStudents}">
					<option value="${student.id}">
						<c:out value="${student.name}" />
					</option>
				</c:forEach>
			</select>
			<input type="submit" class="btn btn-outline-success" value="Add">

		</form>

		<table class="table table-dark">
			<thead>
				<tr>
					<td>Student</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="student" items="${dormStudents }">
				<tr>
					<td>${student.name }</td>
					<td><a href="#">Remove</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>