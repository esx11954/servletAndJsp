<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>confirmation</title>
<style>
td{
	padding: 0px 10px;
}

.enhance{
	color: red;
}
</style>
</head>
<body>
	<h1>確認画面</h1>
	<table border="1">
		<tr>
			<th>ツアー名</th>
			<th>価格</th>
			<th>人数</th>
			<th>合計金額</th>
		</tr>
		<tr>
			<td>${item.name}ツアー</td>
			<td>${item.price}円</td>
			<td>${count}名様</td>
			<td>${total}円</td>
		</tr>
	</table>
	<c:if test="${message != null}">
		<p class="enhance">${message}適用で${item.price * count - total}円引き！</p>
	</c:if>
	<p>上記で間違いないですか？</p>
	<form action="ShopServlet" method="post">
		<input type="submit" name="btn" value="はい">
		<input type="submit" name="btn" value="いいえ">
	</form>
</body>
</html>