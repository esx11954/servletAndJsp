<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit Item</title>
<style type="text/css">
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

.edit,textarea{
	width: 95%;
}

.btn{
	border-radius:3px;
	
}
</style>
</head>
<body>
	<h2>編集してください</h2>
	<form action="BeansServlet" method="post">
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
</body>
</html>