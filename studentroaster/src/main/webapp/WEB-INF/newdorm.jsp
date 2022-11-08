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
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container">
   <h1>New Dorm</h1>
   <a href="/dorms"><button class="btn btn-primary">Dashbord</button></a>
	<form:form action="/dorms/new" method="post" modelAttribute="dorm"
		class="form form-group border m-5 col-8 p-5">
		<form:label path="name">Name</form:label>
		<form:errors path="name"></form:errors>
		<form:input type="text" path="name"  class="d-block m-3"/>
		<input type="submit" class="btn btn-primary btn-block m-3" value="Add">
	</form:form>
   </div>
</body>
</html>