<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>expenses</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Save Travels</h1>
	<div class="container">
		<table class="table table-light">
			<thead>
				<tr>
					<td>Id</td>
					<td>Expense</td>
					<td>Vendor</td>
					<td>amount</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${allexpenses }">
					<tr>
						<td>${expense.id }</td>
						<td>${expense.getExpenseName() }</td>
						<td>${expense.getVendor() }</td>
						<td>${expense.getAmount() }</td>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<form:form action="/expenses" method="post" modelAttribute="expenses"
		class="form form-group border container">
		<p>
			<form:label  path="expenseName">Expense name</form:label>
			<form:errors path="expenseName" />
			<form:input class="form-control" path="expenseName" />
		</p>
		<p>
			<form:label  path="vendor">Vendor</form:label>
			<form:errors path="vendor" />
			<form:input class="form-control" path="vendor" />
		</p>
		<p>
			<form:label  path="description">Description</form:label>
			<form:errors path="description" />
			<form:textarea class="form-control"  path="description" />
		</p>

		<p>
			<form:label  path="amount">amount</form:label>
			<form:errors path="amount" />
			<form:input class="form-control" type="number" path="amount" />
		</p>
		<input type="submit" value="Submit"  class="btn btn-success"/>
	</form:form>


</body>
</html>