<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/addbook.css/">
<title>Book Share</title>
</head>
<body>
	<header>
		<h1>Add book to your shelf!</h1>
		<p>
			<a href="/books/">Back to Shelf</a>
		</p>
	</header>
	<form:form action="/books/new" method="post" modelAttribute="book">
		<div>
			<form:label path="title">Title</form:label>
			<form:input type="text" path="title"></form:input>
			<form:errors path="title"></form:errors>
		</div>
		<div>
			<form:label path="author">Author</form:label>
			<form:input type="text" path="author"></form:input>
			<form:errors path="author"></form:errors>
		</div>
		<div>
			<form:label path="thoughts">My Thoughts</form:label>
			<form:textarea path="thoughts"></form:textarea>
			<form:errors path="thoughts"></form:errors>
		</div>
		<input type="submit" value="Submit!" />
	</form:form>
</body>