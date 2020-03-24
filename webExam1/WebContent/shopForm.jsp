<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Form</title>
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
	<h1>主要都市ツアー申し込みフォーム</h1>
	<p>参加したいツアーにチェックをつけてください</p>
	<p class="enhance">参加人数4名以上のお申し込みで10%OFF!!</p>
	<form action="ShopServlet" method="post">
	<table border="1">
		<tr>
			<th>ツアー名</th>
			<th>参考画像</th>
			<th>価格</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${list}" varStatus="status">
			<tr>
				<td>${item.name}ツアー</td>
				<td><img src = "img/${item.image}" width="128" height="96"></td>
				<td>${item.price}円</td>
				<td>
					<input type="radio" name="itemIndex" value="${status.index}">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2">参加人数を選択してください</td>
			<td colspan="2">
				<select name="count">
					<c:forEach begin="1" end="20" varStatus="status">
						<option value="${status.index}">${status.index}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
	</table>
	<input type="submit" name="btn" value="送信">
	</form>
</body>
</html>