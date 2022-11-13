
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
<title>Book Edit</title>
</head>
<body>
	<header>
		<h1>Change your entry</h1>
		<p>
			<a href="/books/">Back to Shelf</a>
		</p>
	</header>
	<form:form action="/books/edit/${bookToEdit.id}/" method="post"
		modelAttribute="bookToEdit">
		<input type="hidden" name="_method" value="put">
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
</html>