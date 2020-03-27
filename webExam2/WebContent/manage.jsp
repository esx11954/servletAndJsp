<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>manage</title>
</head>
<body>
<h2>商品管理ページ</h2>
	<c:if test="${message != null }">
		<p>${message}</p>
	</c:if>
	
	<form action="ManageServlet" method="get">
		<button name="btn" value="insert">新規商品登録</button>
	</form>
	
	<form action="ManageServlet" method="get">
		<button name="btn" value="search">全商品一覧表示</button>
		<input type="hidden" name="selectWay" value="all">
	</form>
	
	<form action="ManageServlet" method="get">
		<p>商品名で検索</p>
		<input type="text" name="name">
		<button name="btn" value="search">検索</button>
		<input type="hidden" name="selectWay" value="name">
	</form>
	
	<form action="ManageServlet" method="get">	
		<p>カテゴリから検索</p>
		<select name="category">
			<option value="general">雑貨</option>
			<option value="electric">家電</option>
			<option value="book">書籍</option>
			<option value="food">食品</option>
			<option value="fashion">ファッション</option>
			<option value="other">未分類</option>
		</select>
		<button name="btn" value="search">検索</button>
		<input type="hidden" name="selectWay" value="category">
	</form>
		
	<form action="ManageServlet" method="get">	
		<p>値段から検索</p>
		<select name="price">
			<option value="0">0-1500円</option>
			<option value="1">1500-3000円</option>
			<option value="2">3000-5000円</option>
			<option value="3">5000-10000円</option>
			<option value="4">10000円以上</option>
		</select>
		<button name="btn" value="search">検索</button>
		<input type="hidden" name="selectWay" value="price">
	</form>
	
	<c:if test="${list != null }">
		<table border="1">
			<tr>
				<th>商品id</th><th>商品コード</th><th>商品名</th><th>カテゴリ</th><th>価格</th><th></th><th></th>
			</tr>
			
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.id}</td><td>${item.code}</td><td>${item.name}</td><td>${item.category}</td><td>${item.price}</td>
					<td>
						<form action="ManageServlet" method="get">
							<button name="btn" value="edit">変更</button>
							<input type="hidden" name="code" value="${item.code}">
						</form>
					</td>
					<td>
						<form action="ManageServlet" method="get">
							<button name="btn" value="delete">削除</button>
							<input type="hidden" name="code" value="${item.code}">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>