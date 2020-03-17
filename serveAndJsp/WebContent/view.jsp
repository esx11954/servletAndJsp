<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jspページ</title>
</head>
<body>
	<h1>${doWhich}を動かしました</h1>
	<p>${date}</p>
	
	<form action="Servlet" method="get">
		<input type="submit" value="get">
	</form>
	
	<form action="Servlet" method="post">
		<input type="submit" value="post">
	</form>
</body>
</html>