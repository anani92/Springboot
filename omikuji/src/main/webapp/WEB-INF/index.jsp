<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji!</h1>
		<form action="/process" method="POST"
			class="form form-group p-3 m-5 border">

			<label for="yaer">pick any number from 5 - 25</label> <input
				type="number" name="year" id="yaer" min="5" max="25"
				class="form-control" required> <label for="city">Enter
				a name of a city</label> <input type="text" name="city" id="city"
				class="form-control" required> <label for="person">Enter
				a person name</label> <input type="text" name="person" id="person"
				class="form-control" required> <label for="hoppy">Enter
				a hoppy or profession</label> <input type="text" name="hoppy" id="hoppy"
				class="form-control" required> <label for="creature">Enter
				a name for a living thing</label> <input type="text" name="creature"
				id="creature" class="form-control" required> <label
				for="something-nice">Say something nice to someone</label> <input
				type="text" name="something-nice" id="something-nice"
				class="form-control" required>

			<p>Send and show a friend</p>
			<input type="submit" value="submit" class="btn btn-primary btn-lg"
				required>
		</form>
	</div>
</body>
</html>