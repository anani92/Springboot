<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container">
	<h1>new Dojo!</h1>
	<form:form action="/dojo/new" method="post" modelAttribute="dojo"
		class="form form-group border">
		<form:label path="name">Name</form:label>
		<form:errors path="name"></form:errors>
		<form:input type="text" path="name" />
		<input type="submit" class="btn btn-primary" value="Add">
	</form:form>
</body>
</html>