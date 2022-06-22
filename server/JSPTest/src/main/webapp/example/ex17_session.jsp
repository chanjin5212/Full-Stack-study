<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>
	body {
		margin-bottom: 100px;
	}
	a {
		display: block;
		margin-bottom: 5px;
	}
</style>
</head>
<body>

	<!-- ex17_session.jsp -->
	<div class="container">
		
		<h1>세션, Session</h1>
		
		<a href="ex17_set.jsp">세션값 저장하기</a>
		<a href="ex17_del.jsp">세션값 삭제하기</a>
		<a href="ex17_reset.jsp">세션 초기화하기</a>
		<a href="ex17_interval.jsp">세션 만료 시간 지정하기</a>
		
		<hr>
		
		<h2>세션 정보</h2>
		
		<!-- 세션 객체 고유 식별자 -->
		<div>Session ID: <%= session.getId() %></div>
		
		<!-- 세션 객체 생성 시각 -->
		<div>
			Seesion Create Time: 
			<%
				Calendar temp = Calendar.getInstance();
				temp.setTimeInMillis(session.getCreationTime());
				out.println(String.format("%tF %tT", temp, temp));
			%>
		</div>
		
		<!-- 세션 만료 시간(1800초, 30분) -->
		<div>Session Max Inactive Interval: <%= session.getMaxInactiveInterval() %></div>
		
		<!-- 세션이 새로 만들어진건지? 계속 사용중이었던 세션인건지? -->
		<div>Session isNew: <%= session.isNew() %></div>
		
		<!-- 세션 저장소(데이터) -->
		<% if (session.getAttribute("data") != null) { %>
			<div>Session Data: <%= session.getAttribute("data") %></div>
		<% } else { %>
			<div>Session Data: 데이터 없음</div>
		<% } %>
		
		
		
		
		
	</div>
	
	<script>
		
	</script>

</body>
</html>
















