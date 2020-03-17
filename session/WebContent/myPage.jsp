<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>myPage</title>
<style type="text/css">
label{
	display: block;
	float: left;
	width: 200px;
}

input{
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<h2>${bean.name}さんのマイページ</h2>
	<form action="SessionServlet" method="post">
		<label>プロフィールを作成する: </label>
		<input type="submit" name="button" value="profile">
		<br>
		<label>ログアウトする: </label>
		<input type="submit" name="button" value="logout">
	</form>
	
	<c:if test="${bean.age != null}">
		<p>年齢...${bean.age}代</p>
	</c:if>
	
	<c:if test="${bean.gender != null}">
		<p>性別...${bean.gender == "man" ? "男":"女"}</p>
	</c:if>
	
</body>
</html>