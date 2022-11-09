
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Product new</title>
</head>
<body>
	<h1>New Category</h1>
	<p>
		<a href="/">Home</a>
	</p>
	<form:form action="/categories/new" method="post"
		modelAttribute="category">

		<div>
			<form:errors path="name"></form:errors>
			<form:label path="name">Name:</form:label>
			<form:input path="name"></form:input>
		</div>
		<input type="submit" value="Add Category!" />
	</form:form>
</body>
</html>