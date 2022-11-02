<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div class="container">
		<h1>Here's your Omikuji!</h1>

		<div class="pg-light border p-3 m-3">
			<p>
				in
				<c:out value="${year }" />
				years, you will live in
				<c:out value="${city }" />
				with
				<c:out value="${person }" />
				as your roommate, selling
				<c:out value="${hoppy }" />
				for a living. <br> the next time you see
				<c:out value="${creature }" />
				, you will have a good luck. also,
				<c:out value="${somethingNice }" />
				.
			</p>
		</div>
	</div>
</body>
</html>