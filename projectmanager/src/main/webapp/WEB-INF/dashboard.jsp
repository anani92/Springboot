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
<link rel="stylesheet" type="text/css" href="/css/dashboard.css/">
<title>Success Page</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>
				Hello,
				${user.userName}
			</h1>
			<p>allProjects!</p>
		</div>
		<div>
			<p>
				<a href="/logout/">Logout</a>
			</p>
			<p>
				<a href="/projects/">Back to shelf!</a>
			</p>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Project</td>
				<td>Team lead</td>
				<td>Due date</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${availableprojects}">
				<tr>
					<td><c:out value="${project.id}"></c:out></td>
					<td><a href="/project/${project.id}/"><c:out
								value="${project.title}"></c:out></a></td>
					<td><c:out value="${project.author}"></c:out></td>
					<td><c:out value="${project.user.userName}"></c:out></td>
					<td><c:set var="projectDB" value="${project}" /> <c:set var="user"
							value="${user}" /> <c:if test="${project.user.id == user.id}">
							<a href="/projects/edit/${project.id}/">Edit</a>
							<form action="/projects/delete" method="post">
								<input type="hidden" name="_method" value="delete" /> <input
									type="hidden" name="projectid" value="${project.id}" /> <input
									type="submit" value="Delete" />
							</form>
						</c:if> <c:if test="${project.user.id != user.id}">
							<form action="/projects/addMember/${project.id}/" method="post">
								<input type="hidden" name="_method" value="put" /> <input
									type="hidden" name="borrowId" value="${user.id}" /> <input
									type="submit" value="Borrow" />
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />
	<h2>projects I am borrowing</h2>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Author Name</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${borrowedprojects}">
				<tr>
					<td><c:out value="${project.id}"></c:out></td>
					<td><a href="/projects/${project.id}/"><c:out
								value="${project.title}"></c:out></a></td>
					<td><c:out value="${project.author}"></c:out></td>
					<td><c:if test="${projects.size() != 0 }">
							<form action="/projects/return/${project.id}/" method="post">
								<input type="hidden" name="_method" value="put" /> <input
									type="submit" value="Return" />
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>