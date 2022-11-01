<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h2>
		You have visited <a href="/">homePage</a> <c:out value="${count }" /> times.
	</h2>
	<h3><a href="/">Test another visit?</a></h3>
	</div>
</body>
</html>