<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<title>Time Dashboard</title>
</head>
<body>
	<div>
		<h1>Time: <c:out value="${time}" /></h1>
		<button>
			<a href="/">back</a>
		</button>
		
	</div>
</body>
</html>