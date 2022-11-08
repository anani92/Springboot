<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Roaster</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
   <div class="container">
   <h1>New student</h1>
   <form:form action="/students/new" method="post" modelAttribute="student"
		class="form form-group border">
		<form:label path="name">Name</form:label>
		<form:errors path="name"></form:errors>
		<form:input type="text" path="name" />
		<form:select path="dorm">
			<c:forEach var="dorm" items="${dorms }">
				<form:option value="${dorm.id }">${dorm.name }</form:option>
			</c:forEach>
		</form:select>
		<input type="submit" class="btn btn-primary" value="Add">
	</form:form>
   </div>
</body>
</html>