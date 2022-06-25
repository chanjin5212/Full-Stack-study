<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//내장 객체 생명 주기 + 페이지 이동 시 데이터 전달하기
	
	//1. 지역 변수 > 실패
	int a = 10;
	
	//3. pageContext 객체
	pageContext.setAttribute("c", 30);
	
	//4. request 객체
	request.setAttribute("d", 40);
	
	//5. session 객체
	session.setAttribute("e", 50);
	
	//6. application 객체
	application.setAttribute("f", 60);

	//response.sendRedirect("ex21_scope_2.jsp");
	
	//pageContext.forward("ex21_scope_2.jsp");
	
	
	
	//생명주기
	//- pageContext < request < 
	
%>
<%!

	//2. 멤버 변수 > 실패
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
	
	<!-- ex21_scope_1.jsp -->
	<div class="container">
		<h1>첫번째 페이지</h1>
		
		<a href="ex21_scope_2.jsp">두번째 페이지로 이동하기</a>
	</div>
	
	<script>
	
	</script>
	
</body>
</html>