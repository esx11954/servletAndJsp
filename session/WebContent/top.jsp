<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>top</title>
<style type="text/css">
label{
	display: block;
	float: left;
	width: 60px;
}
</style>
</head>
<body>
	<h1>ログインページ</h1>
	<p>${message}</p>
	<form action="SessionServlet" method="post">
		<label>Name: </label>
		<input type="text" name="name">
		<br>
		<label>Pass: </label>
		<input type="password" name="pass">
		<input type="submit" name="button" value="login">
	</form>
</body>
</html>