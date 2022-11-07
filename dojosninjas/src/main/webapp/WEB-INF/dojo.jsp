<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class='contianer'>
		<h1>${dojo.name }</h1>

		<table class="table table-secondary">
			<thead>
				<tr>
					<td>first name</td>
					<td>last name</td>
					<td>Age</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${dojo.ninjas}">
				<tr>
					<td>${ninja.firstName }</td>
					<td>${ninja.lastName }</td>
					<td>${ninja.age }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>