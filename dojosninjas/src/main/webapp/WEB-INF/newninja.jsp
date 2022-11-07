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
<body>
	<h1>new Ninja!</h1>
	<form:form action="/ninja/new" method="post" modelAttribute="ninjas"
		class="form form-group border container">
		<form:label path="firstName">first name</form:label>
		<form:errors path="firstName"></form:errors>
		<form:input type="text" path="firstName" />
		<form:label path="lastName">last name</form:label>
		<form:errors path="lastName"></form:errors>
		<form:input type="text" path="lastName" />
		<form:label path="age">Age</form:label>
		<form:errors path="age"></form:errors>
		<form:input type="number" path="age" />
		<form:select path="dojo">
			<c:forEach var="dojo" items="${dojos}">
				<form:option value="${dojo.id}" path="person">
					<c:out value="${dojo.name}" />
				</form:option>
			</c:forEach>

		</form:select>
		<input type="submit" class="btn btn-danger" value="Add">

	</form:form>
</body>
</html>