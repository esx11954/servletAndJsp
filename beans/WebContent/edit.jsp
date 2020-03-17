<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit Item</title>
<link rel="stylesheet" href="bean.css">
</head>
<body>
	<div class="title"><h2>${editOrAdd}してください</h2></div>
	
	<form action="${servlet}" method="post">
	<table>
		<tr>
			<th class="col1">料理名</th>
			<th class="col2">値段(円)</th>
			<th class="col3">カロリー(kcal)</th>
			<th class="col4">説明</th>
			<th class="col5"></th>
		</tr> 
		<tr>			
			<td><input class="edit" type="text" size="10" name="foodName" value="${editItem.foodName}"></td>
			<td><input class="edit" type="text" size="10" name="price" value="${editItem.price}"></td>		
			<td><input class="edit" type="text" size="10" name="kcal" value="${editItem.kcal}"></td>		
			<td><textarea name="description">${editItem.description}</textarea></td>
			<td><input class="btn" type="submit" name="btn" value="確定"></td>
		</tr>
	</table>
	</form>
	<c:if test ="${editOrAdd == '編集'}">
		<form class="delForm" action="DeleteMenuServlet" method="get">
			<input class="deletebtn" type="submit" value="削除する">
			<input type="hidden" name="index" value="${index}">
		</form>
	</c:if>
</body>
</html>