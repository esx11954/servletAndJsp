<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
table{
	border-collapse: collapse;
	border: solid 2px orange;
}

th{
	background-color: #fa8072;
	color: #ffffff;
}

td{
	padding-top: 10px;
	padding-bottom: 10px;
}

.col1{
	width: 5%;
}

.col2{
	width: 15%;
}

.col3{
	width: 70%;
}

.id, .date{
	text-align: center;
}

.message{
	color: red;
}

</style>
</head>
<body>
	<h1>Hey! Guys!</h1>
	<h2>ハロー！ワールド！</h2>
	<c:if test="${message != null}">
		<p class="message">${message}</p>
	</c:if>

	<p>適当になにか入力してください</p>
	<p>入力した内容がDBに保存されます</p>
	<form action="webServlet" method="post">
		<textarea name="text" rows="4" cols="30"></textarea>
		<br>
		<input type="submit" name="button" value="submit">
	</form>
	<br>
	<c:if test="${list != null}">
		<table>
			<tr>
				<th class="col1">id</th>
				<th class="col2">date</th>
				<th class="col3">content</th>
				<th></th>
			</tr>
			<c:forEach var="i" items="${list}">
				<tr>
					<td class="id">${i.id}</td>
					<td class="date">${i.date}</td>
					<td class="content">${i.content}</td>
					<td>
						<form action="webServlet" method="post">
							<input type="submit" name="button" value="削除"><input type="hidden" name="index" value="${i.id}">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>