<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>beans top</title>
<style>
table{
	border-collapse: collapse;
	border: solid 2px orange;
}

table th, table td {
  border: solid 1px red;
}

th{
	background-color: #fa8072;
	color: #ffffff;
}

td{
	padding-top: 10px;
	padding-bottom: 10px;
}

.center{
	text-align: center;
}

.col1{
	width: 10%;
}

.col2{
	width: 6%;
}

.col3{
	width: 6%;
}

.col4{
	width: 70%;
}

.btn{
	border-radius:3px;
}

p{
	color: red;
	text-align: center;
}
</style>
</head>
<body>
	<h1>メニュー一覧</h1>
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
		<c:forEach var="menu" items="${menuList}" varStatus="status">
			<tr>
				<td class="center">${menu.foodName}</td>
				<td class="center">${menu.price}</td>
				<td class="center">${menu.kcal}</td>
				<td>${menu.description}</td>
				<td class="center">
				<form action="BeansServlet" method="post">
					<input type="hidden" name="index" value="${status.index}">
					<input class="btn" type="submit" name="btn" value="変更">
				</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>