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

</style>
</head>
<body>

	<!-- ex16_session_1.jsp -->
	<div class="container">
		<h1>방문 횟수</h1>
		<div>session: <%= session.getAttribute("count") %></div>
		<div>application: <%= application.getAttribute("count") %></div>
	</div>
	
	<script>
		
	</script>

</body>
</html>
















