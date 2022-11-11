<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
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
	<h1>Welcome, ${user.userName } !</h1>
	<h2>Books from everyone shelves</h2>
	<div>
		<p>Books from everyone's shelves</p>
	</div>
	<div>
		<p>
			<a href="/logout/">Logout</a>
		</p>
		<p>
			<a href="/books/new/">+ Add to my shelf!</a>
		</p>
	</div>
	<table class="table table-light">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Author Name</td>
				<td>Posted By</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${allbooks}">
				<tr>
					<td><c:out value="${book.id}"></c:out></td>
					<td><a href="/books/${book.id}/"><c:out
								value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:out value="${book.user.userName}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>