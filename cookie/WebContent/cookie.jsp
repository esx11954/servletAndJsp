<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cookie</title>
<link rel="stylesheet" href="cookieStyle.css">
</head>
<body>

	<div>
		<h1>${title}</h1>
		<form action="CookieServlet" method="post">
			<label>ID:</label>
			<input type="text" name="id" value="${valueId}" placeholder="IDを入力してね">
			<br>
			<label>Pass:</label>
			<input type="password" name="pass" value="${valuePass}" placeholder="パスワードを入力してね">
			<input class="submit" type="submit" name="button" value="submit">
		</form>
	</div>
</body>
</html>