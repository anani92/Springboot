<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>title</td>
				<td>language</td>
				<td>description</td>
				<td>number of pages</td>
				<td>actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books }">
				<tr>
					<td>${book.id }</td>
					<td>${book.title }</td>
					<td>${book.language }</td>
					<td>${book.description }</td>
					<td>${book.numberOfPages }</td>
					<td>
						<a href="/books/${book.id }/edit">edit</a>
						<a href="/books/${book.id }">view</a>
						<form action="/books/${book.id}" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete">
						</form></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>