<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Result</title>
</head>
<body>
	<h1>${text}</h1>
	<c:if test="${flag}">
		<c:forEach var="i" items="${list}">
			<img src="ida.jpg" width="50" height="50">
			<!--  <p>${i}</p> -->
		</c:forEach>
	</c:if>
	
	<a href="http://localhost:8080/parameter/param.html">戻る</a>
</body>
</html>