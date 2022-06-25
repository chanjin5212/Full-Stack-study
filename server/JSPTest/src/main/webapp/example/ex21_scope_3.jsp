<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//1. 지역 변수
	int a = 10;

	//3.
	pageContext.setAttribute("c", 30);
	
	//4.
	request.setAttribute("d", 40);

%>
<%!
	//2. 멤버 변수
	int b = 20;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- ex21_scope_3.jsp -->
	<div class="container">
		<h1>부모 페이지</h1>
		
		부모 페이지 영역
		
		<hr>
		
		<%@ include file="inc/ex19_sub.jsp" %>
		
		<hr>
		
		부모 페이지 영역
		
		
	</div>
	
	<script>
	
	</script>
	
</body>
</html>