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
				Hello
				<c:out value="${user.userName}"></c:out>
			</h1>
			<p>The Book Broker!</p>
			<p>Available books to borrow</p>
		</div>
		<div>
			<p>
				<a href="/logout/">Logout</a>
			</p>
			<p>
				<a href="/books/">Back to shelf!</a>
			</p>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Author Name</td>
				<td>Posted By</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${availableBooks}">
				<tr>
					<td><c:out value="${book.id}"></c:out></td>
					<td><a href="/books/${book.id}/"><c:out
								value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:out value="${book.user.userName}"></c:out></td>
					<td><c:set var="bookDB" value="${book}" /> <c:set var="user"
							value="${user}" /> <c:if test="${book.user.id == user.id}">
							<a href="/books/edit/${book.id}/">Edit</a>
							<form action="/books/delete" method="post">
								<input type="hidden" name="_method" value="delete" /> <input
									type="hidden" name="bookid" value="${book.id}" /> <input
									type="submit" value="Delete" />
							</form>
						</c:if> <c:if test="${book.user.id != user.id}">
							<form action="/books/borrow/${book.id}/" method="post">
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
	<h2>Books I am borrowing</h2>
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
			<c:forEach var="book" items="${borrowedBooks}">
				<tr>
					<td><c:out value="${book.id}"></c:out></td>
					<td><a href="/books/${book.id}/"><c:out
								value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:if test="${borrowedBooks.size() != 0 }">
							<form action="/books/return/${book.id}/" method="post">
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