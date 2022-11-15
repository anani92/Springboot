<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Road Share</title>
</head>
<body>
	<header>
		<h1>${project.projectName}</h1>
		<p>
			<a href="/projects/home">Back to dashboard</a>
		</p>
	</header>
	<h2>Description: ${project.description }</h2>
	<h2>Due date:${project.dueDate }</h2>

	<c:set var="book" value="${book}" />
	<c:set var="user" value="${user}" />
	<c:if test="${book.user.id == user.id}">

		<a href="/books/edit/${book.id}/">Edit</a>
		<form action="/books/delete" method="post">
			<input type="hidden" name="_method" value="delete" /> <input
				type="hidden" name="bookid" value="${book.id}" /> <input
				type="submit" value="Delete" class="btn btn-danger" />
		</form>
	</c:if>
	<h3>
		<a href="/project/${project.id}/tasks"> seeTasks</a>
	</h3>
</body>
</html>