<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Categories's Page</title>
</head>
<body>
	<h1>Category's Page</h1>
	<p>
		<a href="/">Home</a>
	</p>
	<hr />
	<h2>Products:</h2>
	<c:forEach var="product" items="${category.products}">
		<ul>
			<li><c:out value="${product.name}"></c:out></li>
		</ul>
	</c:forEach>
	<hr />
	<h2>Add Product</h2>

	<form action="/category/addproduct" method="post">
		<div>
			<input type="hidden" name="categoryId" value="${category.id}" />
			<select name="productId">
				<c:forEach var="product" items="${productsNotContaining}">
					<option value="${product.id}"><c:out
							value="${product.name}"></c:out></option>
				</c:forEach>
			</select>
		</div>
		<input type="submit" value="Add Product to this Category!" />
	</form>
</body>
</html>