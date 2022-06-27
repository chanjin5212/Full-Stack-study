<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//1. 인증 티켓 삭제하기
	// - 로그아웃 != 세션 초기화
	
	session.removeAttribute("auth"); //로그아웃
	
	session.removeAttribute("name");
	session.removeAttribute("lv");
	
	
	//session.invalidate(); //세션 초기화

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/auth/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!--  -->
	<div class="container">
	
	</div>
	
	<script>
		location.href = 'index.jsp';
	</script>
	
</body>
</html>