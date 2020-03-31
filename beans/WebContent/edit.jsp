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
			
			<!-- ここに記入してください -->
			
		</tr>
	</table>
	</form>
	
	<!-- ここに記入してください -->
	
</body>
</html>