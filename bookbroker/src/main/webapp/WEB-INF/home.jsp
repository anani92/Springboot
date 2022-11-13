<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
</head>
<body>
	<h1>Welcome, ${user.userName } !</h1>
	<h2>The book broker</h2>
	<div>
		<p>Available books to borrow!</p>
	</div>
	<div>
		<p>
			<a href="/logout/">Logout</a>
		</p>
		<p>
			<a href="/books/new">+ Add to my shelf!</a>
		</p>
	</div>
	<table class="table table-light">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Author Name</td>
				<td>Owner</td>
				<td>actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${allbooks}">
				<tr>
					<td><c:out value="${book.id}"></c:out></td>
					<td><a href="/books/${book.id}/"><c:out
								value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:out value="${book.user.userName}"></c:out></td>
					<td class="d-flex"><c:if
							test="${book.borrower == null && book.user.id != user.id }">
							<form action="/books/borrow/${book.id}/" method="post">
								<input type="hidden" name="_method" value="put" /> <input
									type="hidden" name="borrowId" value="${user.id}" /> <input
									type="submit" value="Borrow" />
							</form>
						</c:if> <c:if test="${book.user.id == user.id }">
							<a href="/books/edit/${book.id}/">Edit</a>
							<form action="/books/delete" method="post">
								<input type="hidden" name="_method" value="delete" /> <input
									type="hidden" name="bookid" value="${book.id}" /> <input
									type="submit" value="Delete" />
							</form>
							
						</c:if> 
							<c:if test="${book.user.id != user.id && book.borrower != null }">borrowed</c:if>
							
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>