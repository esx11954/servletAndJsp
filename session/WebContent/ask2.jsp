<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>質問２</title>
<link rel="stylesheet" href="./style/ask.css">
</head>
<body>
	<div>
		<p>あなたの性別は？</p>
		<form action="SessionServlet" method="post">
			<label><input type="radio" name="gender" value="man" checked> 男性</label>
			<label><input type="radio" name="gender" value="woman"> 女性</label>
			<input type="hidden" name="askNo" value="2">
			<input type="submit" name="button" value="next">
			<br>
		</form>
	</div>
</body>
</html>