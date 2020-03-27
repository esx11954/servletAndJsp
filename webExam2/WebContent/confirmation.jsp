<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>confirm</title>
</head>
<body>
	<h2>以下の商品を削除します</h2>
	<table border="1">
		<tr>
			<th>商品ID</th><th>商品コード</th><th>商品名</th><th>カテゴリ</th><th>価格</th>
		</tr>
		<tr>
			<td>${item.id}</td><td>${item.code}</td><td>${item.name}</td><td>${item.category}</td><td>${item.price}</td>
		</tr>
	</table>
	<p>よろしいですか？</p>
	<form action="DeleteServlet" method="post">
		<button name="btn" value="yes">はい</button>
		<button name="btn" value="no">いいえ</button>
		<input type="hidden" name="code" value="${item.code}">
	</form>
</body>
</html>