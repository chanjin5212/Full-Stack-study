<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>add.jsp</h1>
	
	<h2>단일 데이터</h2>
	
	<form method="POST" action="/spring/addok.do">
		<input type="text" name="num">
		<input type="submit" value="보내기">
	</form>
	
	<h2>다중 데이터</h2>
	<form method="POST" action="/spring/addok.do">
		<input type="text" name="name">
		<input type="text" name="age">
		<input type="text" name="address">
		<input type="submit" value="보내기">
	</form>
	
	<h2>다중 데이터</h2>
	<form method="POST" action="/spring/addok.do">
		<input type="checkbox" value="1" name="cb">사과
		<input type="checkbox" value="2" name="cb">딸기
		<input type="checkbox" value="3" name="cb">바나나
		<input type="checkbox" value="4" name="cb">수박
		<input type="checkbox" value="5" name="cb">포도
		<input type="submit" value="보내기">
	</form>
	
</body>
</html>









