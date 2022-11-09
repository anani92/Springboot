<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Product's Page</title>
</head>
<body>
	<h1>Product's Page</h1>
	<p>
		<a href="/">Home</a>
	</p>
	<hr />
	<h2>Categories:</h2>
	<p>Modify and render all categories for this product</p>
	<c:forEach var="category"
		items="${product.categories}">
		<ul>
			<li><c:out value="${category.name}"></c:out></li>
		</ul>
	</c:forEach>
	<hr />
	<h2>Add Category</h2>

	<form action="/product/addcategory" method="post">
		<div>
			<input type="hidden" name="productId" value="${product.id}" />
			<select name="categoryId">
				<c:forEach var="category" items="${categoriesNotContaining}">
					<option value="${category.id}">
							<c:out
							value="${category.name}"></c:out></option>
				</c:forEach>
			</select>
		</div>
		<input type="submit" value="Add Category to this Product!" />
	</form>
</body>
</html>