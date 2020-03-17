<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>el expression</title>
</head>
<body>
	<h1>${head}</h1>
	<p>${3 + 3}</p>
	<p>${3 == 3}</p>
	<p>method: ${method == "get" ? "get" : "post"}</p>
	
	<form action="ElJstlServlet" method="${method}">
		<input type="submit" value="Go to ${requestScope.method}">
	</form>
	
	<p>${pageContext}</p>
	<p>${cookie}</p>
	<p>${header}</p>
</body>
</html>