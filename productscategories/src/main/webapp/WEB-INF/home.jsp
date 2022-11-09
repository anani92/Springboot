<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Roaster</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<h1>Home</h1>
		<div>
			<h3>
				<a href="/products/new">Add new product</a>
			</h3>
			<h3>
				<a href="/categories/new">Add new category</a>
			</h3>


		</div>
		<table class="table table-light col-6">
			<thead>
				<tr>
					<td>Products</td>
					<td>Categories</td>
				</tr>
			</thead>
			<tbody>

				<tr>

					<td>
						<ul>
							<c:forEach var="product" items="${ allProducts}">
								<li><a href="/product/${product.id}"><c:out value="${product.name}"></c:out></a></li>
							</c:forEach>
						</ul>

					</td>

					<td>
						<ul>
							<c:forEach var="category" items="${ allCategories}">
								<li><a href="/category/${category.id }"><c:out value="${category.name }"></c:out></a></li>
							</c:forEach>
						</ul>
					</td>

				</tr>

			</tbody>
		</table>

	</div>
</body>
</html>