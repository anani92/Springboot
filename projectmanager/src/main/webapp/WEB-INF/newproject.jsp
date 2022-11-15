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
<title>Project manager</title>
</head>
<body>
	<header>
		<h1>new Project!</h1>
		<p>
			<a href="/projects/home">Back to dashboard</a>
		</p>
	</header>
	<form:form action="/projects/new" method="post"
		modelAttribute="newProject">
		<div>
			<form:label path="projectName">project name</form:label>
			<form:input type="text" path="projectName"></form:input>
			<form:errors path="projectName"></form:errors>
		</div>
		<div>
			<form:label path="description"> description</form:label>
			<form:textarea path="description"></form:textarea>
			<form:errors path="description"></form:errors>
		</div>
		<div>
			<form:label path="dueDate"> Due date</form:label>
			<form:input type="date" path="dueDate"></form:input>
			<form:errors path="dueDate"></form:errors>
		</div>
		<input type="submit" value="Submit!" />
	</form:form>
</body>