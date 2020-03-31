<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>beans top</title>
<link rel="stylesheet" href="bean.css">
</head>
<body>
	<div class="title"><h2>MENU</h2></div>
	
	<form action="AddMenuServlet" method="get">
		<input class="btn float" type="submit" name="btn" value="メニューを追加する">
	</form>
	<form action="DeleteMenuServlet" method="post">
		<input class="btn float" type="submit" name="btn" value="メニューを初期化する">
	</form>
	
	<c:if test ="${message != null}">
		<p>${message}</p>
	</c:if>
	<table>
		<tr>
			<th class="col1">料理名</th>
			<th class="col2">値段(円)</th>
			<th class="col3">カロリー(kcal)</th>
			<th class="col4">説明</th>
			<th class="col5"></th>
		</tr>
		
		<!-- ここに記入してください -->
		
	</table>
</body>
</html>