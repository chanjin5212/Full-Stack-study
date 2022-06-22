<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//페이지 > (이동) > 페이지
	
	//1. HTML
	//	- <a href="">
	//	- 사용자 클릭을 통해서
	
	//2. JavaScript
	//	- location.href = "";
	//	- 자유롭게 프로그램으로 제어 가능
	//	- 클라이언트측 제어
	
	//3. Servlet/JSP
	//	- response.sendRedirect("");
	//	- 자유롭게 프로그램으로 제어 가능
	//	- 서버측 제어
	
	//1번 페이지 접속 > 업무 처리 > 완료 > 2번 페이지 이동
	
	//비즈니스 업무 실행~
	//2번 페이지 이동
	response.sendRedirect("ex13_response_2.jsp");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<!-- ex13_response_1.jsp -->
	<div class="container">
		<h1>1번 페이지</h1>
	</div>
	
	<script>
		
	</script>

</body>
</html>
















