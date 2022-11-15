
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/style2.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="flex1">
		<h3>Welcome, ${user.userName}</h3>
		<p>
			<a href="/logout">logout</a>
		</p>
	</div>
	<h3>all projects</h3>
	<table class="table">
		<thead class="thead-dark">
			<tr>


				<th scope="col">Project</th>
				<th scope="col">Team Lead</th>
				<th scope="col">Due Date</th>
				<th scope="col">Actions</th>



			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${availableProjects}">
				<c:if test="${user.id != project.teamLead.id}">
					<tr>


						<td><a href="/projects/${project.id}">${project.projectName}</a></td>

						<td><c:out value="${project.teamLead.userName}"></c:out></td>
						<td><c:out value="${project.dueDate}"></c:out></td>

						<td>

							<form action="/projects/join/${project.id}/" method="post">
								<input type="hidden" name="_method" value="put" /> <input
									type="submit" value="join" />
							</form>
						</td>




					</tr>
				</c:if>
			</c:forEach>


		</tbody>
	</table>

	<h3>your projects</h3>
	<table class="table">
		<thead class="thead-dark">
			<tr>


				<th scope="col">Project</th>
				<th scope="col">Team Lead</th>
				<th scope="col">Due Date</th>
				<th scope="col">Actions</th>



			</tr>
		</thead>

		<tbody>

			<c:forEach var="project" items="${userProjects}">
				<tr>


					<td><a href="/projects/${project.id}">${project.projectName}</a></td>

					<td><c:out value="${project.teamLead.userName}"></c:out></td>
					<td><c:out value="${project.dueDate}"></c:out></td>
					<c:if test="${user.id != project.teamLead.id}">
						<td>
							<form action="/projects/leave/${project.id}/" method="post">
								<input type="hidden" name="_method" value="put" /> <input
									type="submit" value="leave" />
							</form>
						</td>
					</c:if>

					<c:if test="${user.id == project.teamLead.id}">
						<td><a href="/projects/edit/${project.id}">edit</a>
							<form action="/projects/delete/${project.id}/" method="post">
								<input type="hidden" name="_method" value="delete" /> <input
									type="submit" value="delete" />
							</form></td>
					</c:if>


				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>