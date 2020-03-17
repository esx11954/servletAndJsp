<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>myPage</title>
<link rel="stylesheet" href="./style/mypage.css">
</head>
<body>
	<div>
		<h2><strong>${bean.name}</strong>さんのマイページ</h2>
		<form action="SessionServlet" method="post">
			<label>プロフィールを作成する: </label>
			<input type="submit" name="button" value="profile">
			<br>
			<label>ログアウトする: </label>
			<input type="submit" name="button" value="logout">
		</form>
		
		<c:if test="${bean.age != null}">
			<p>年齢...<strong>${bean.age}代</strong></p>
		</c:if>
		
		<c:if test="${bean.gender != null}">
			<p>性別...<strong>${bean.gender == "man" ? "男":"女"}</strong></p>
		</c:if>
	</div>
</body>
</html>