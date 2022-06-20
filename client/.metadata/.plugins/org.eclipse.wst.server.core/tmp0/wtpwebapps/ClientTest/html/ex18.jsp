<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>서버측 페이지</h1>
	
	<%
		//자바(Java)
		String txtName = request.getParameter("txtName");
	%>
	
	<p>이름: <%= txtName %></p>
	
	
</body>
</html>










