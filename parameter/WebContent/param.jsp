<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Result</title>
<link rel="stylesheet" href="${cssFile}.css">
</head>
<body>
	<h1>${text}</h1>
	<a href="http://localhost:8080/parameter/param.html">戻る</a>
		<c:if test="${flag}">
			<div class="container">
				<c:forEach var="i" items="${list}">
					<!-- <img src="ida.jpg" width="50" height="50"> -->
					<div class="float" style="background-color : ${i}"></div>
				</c:forEach>
			</div>
		</c:if>
</body>
</html>