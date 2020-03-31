<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="hedder">
		<h1>Hello World</h1>
	</div>
	<div class="content">
	
		<div class="post">
			
			<!-- ここに記入してください -->
		
			<form action="DBServlet" method="post">
				<textarea name="text" rows="4" cols="30" class = "textbox-radius" placeholder="いまなにしている？"></textarea>
				<input type="submit" name="button" value="POST" class="button-radius">
			</form>
		</div>
		<br>
		
		<!-- ここに記入してください -->
		
	</div>
</body>
</html>