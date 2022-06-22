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

	<!-- ex15_out.jsp -->
	<div class="container">
		
		<h1>out</h1>
		
		<%			
			int dan = 2;		
		%>
		
		<h2>구구단 - 스크립틀릿 + 표현식 사용</h2>
		
		<% for (int i=1; i<=9; i++) { %>
		<div><%= dan %> x <%= i %> = <%= dan*i %></div>
		<% } %>
		
		
		<h2>구구단 - 스크립틀릿 + out 객체 사용</h2>
		<%
			for (int i=1; i<=9; i++) {
				out.println(String.format("<div>%d x %d = %d</div>"
													, dan, i, dan*i));
			}
		%>
		
	</div>
	
	<script>
		
	</script>

</body>
</html>
















