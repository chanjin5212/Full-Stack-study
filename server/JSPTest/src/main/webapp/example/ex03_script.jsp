<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  

	JSP 페이지 + JSP 요소 > 자원 경로(URL)
	1. 상대경로
	2. 절대경로
		- '/' > webapp

-->
<%@ include file="/example/inc/asset.jsp" %>
</head>
<body>
	<!-- ex03_script.jsp -->
	
	<div class="container">
	
		<h1>스크립틀릿 + 표현식</h1>
		
		<%
		
			//자바 코드 작성
			int a = 10;
			int b = 20;
			int c = a + b;
		
		%>
		
		<div class="alert alert-secondary">결과: <%= c %></div>
		
		
		<h1>구구단 5단</h1>
		
				
		<% 
			for (int i=1; i<=9; i++) { 
		%>
				<div>5 x <%= i %> = <%= i*5 %></div>
		<%
			} 		
		%>
		
		
	
	</div>
	
	
	
	
</body>
</html>

























