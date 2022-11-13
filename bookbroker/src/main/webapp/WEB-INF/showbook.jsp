
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
		<h1>${book.title}</h1>
		<p>
			<a href="/books/home">Back to Shelf</a>
		</p>
	</header>
	<c:set var="book" value="${book}" />
	<c:set var="user" value="${user}" />
	<c:if test="${book.user.id == user.id}">
		<p>
			You read,
			<c:out value="${book.title}" />
			by
			<c:out value="${book.author}" />
		</p>
		<p>Here are your thoughts</p>
		<p>
			<c:out value="${book.thoughts}" />
		</p>
		<a href="/books/edit/${book.id}/">Edit</a>
		<form action="/books/delete" method="post">
			<input type="hidden" name="_method" value="delete" /> <input
				type="hidden" name="bookid" value="${book.id}" /> <input
				type="submit" value="Delete" />
		</form>
	</c:if>
	<c:if test="${book.user.id != user.id}">
		<p>
			<c:out value="${user.userName}" />
			read,
			<c:out value="${book.title}" />
			by
			<c:out value="${book.author}" />
		</p>
		<p>
			Here are
			<c:out value="${book.user.userName}" />
			thoughts
		</p>
		<p>
			<c:out value="${book.thoughts}" />
		</p>
	</c:if>
</body>
</html>