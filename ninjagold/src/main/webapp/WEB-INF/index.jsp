<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Ninja Gold Game</title>
</head>
<body class="container">
	<h3 class="m-3">
		Your Gold: <span><c:out value="${gold }"></c:out></span>
	</h3>
	<div class="d-flex justify-content-around">
		<div class="border p-3">
			<h3>Farm</h3>
			<h3>(earns 10-20 gold)</h3>
			<form action="/processmoney" method="POST">
				<input type="hidden" name="whichForm" value="farm"> <input
					type="submit" value="Find Gold!"
					class="btn btn-outline-success btn-block">
			</form>
		</div>
		<div class="border p-3">
			<h3>Cave</h3>
			<h3>(earns 10-20 gold)</h3>
			<form action="/processmoney" method="POST">
				<input type="hidden" name="whichForm" value="cave"> <input
					type="submit" value="Find Gold!"
					class="btn btn-outline-success btn-block">
			</form>
		</div>
		<div class="border p-3">
			<h3>House</h3>
			<h3>(earns 10-20 gold)</h3>
			<form action="/processmoney" method="POST">
				<input type="hidden" name="whichForm" value="house"> <input
					type="submit" value="Find Gold!"
					class="btn btn-outline-success btn-block">
			</form>
		</div>
		<div class="border p-3">
			<h3>Quest</h3>
			<h3>(earns/takes 50 gold)</h3>
			<form action="/processmoney" method="POST">
				<input type="hidden" name="whichForm" value="quest"> <input
					type="submit" value="Find Gold!"
					class="btn btn-outline-success btn-block">
			</form>
		</div>
	</div>
	<div class="d-block m-5">
		<h3>Activities:</h3>
		<div name="activities" class="bg-light border d-block scroll" height="400">
			<c:forEach items="${activities}" var="item">
	    		${item}
			</c:forEach>
        </div>
	</div>
</body>
</html>