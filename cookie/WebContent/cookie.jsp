<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cookie</title>
<style type="text/css">
label{
	display: block;
	float: left;
	width: 50px;
}
</style>
</head>
<body>
	<h1>${title}</h1>
	
	<form action="CookieServlet" method="post">
		<label>ID:</label>
		<input type="text" name="id" value="${idValue}">
		<br>
		<label>Pass:</label>
		<input type="password" name="pass" value="">
		<input type="submit" name="button" value="submit">
	</form>
</body>
</html>