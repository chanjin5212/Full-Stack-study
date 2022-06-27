<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	

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
	
	<!-- webapp > WEB-INF > views > hello.jsp -->
	<div class="container">
		<h1>Hello</h1>
		DB : <%= request.getAttribute("name") %>
		
		
	</div>
	
	<script>
	
	</script>
	
</body>
</html>