<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>質問１</title>
<link rel="stylesheet" href="./style/ask.css">
</head>
<body>
	<div>
		<p>あなたは何歳ですか？</p>
		<form action="SessionServlet" method="post">
			<select name="age">
			    <option value="10">10代</option>
			    <option value="20">20代</option>
			    <option value="30">30代</option>
			    <option value="40">40代</option>
			</select>
			<input type="hidden" name="askNo" value="1">
			<input type="submit" name="button" value="next">
			<br>
		</form>
	</div>
</body>
</html>