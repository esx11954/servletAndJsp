<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>search</title>
</head>
<body>
	<h2>商品検索</h2>
	<a href="http://localhost:8080/webExam2/MainController?page=manage">管理ページへ</a>
	<form action="SearchServlet" method="post">
		<p>商品名で検索</p>
		<input type="text" name="name">
		<button name="btn" value="name">検索</button>
		
		<p>カテゴリから検索</p>
		<select name="category">
			<option value="general">雑貨</option>
			<option value="electric">家電</option>
			<option value="book">書籍</option>
			<option value="food">食品</option>
			<option value="fashion">ファッション</option>
		</select>
		<button name="btn" value="category">検索</button>
		
		<p>値段から検索</p>
		<select name="price">
			<option value="0">0-1500円</option>
			<option value="1">1500-3000円</option>
			<option value="2">3000-5000円</option>
			<option value="3">5000-10000円</option>
			<option value="4">10000円以上</option>
		</select>
		<button name="btn" value="price">検索</button>
		<p>全商品一覧</p>
		<button name="btn" value="all">表示</button>
	</form>
	
	<c:if test="${message != null }">
		<p>${message}</p>
	</c:if>
	
	<c:if test="${list != null }">
		<table border="1">
			<tr>
				<th>商品id</th><th>商品コード</th><th>商品名</th><th>カテゴリ</th><th>価格</th>
			</tr>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.id}</td><td>${item.code}</td><td>${item.name}</td><td>${item.category}</td><td>${item.price}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>