<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="inc/asset.jsp" %>
</head>
<body>
	<!-- ex12_request.jsp -->
	
	<p>요청 URL: <%= request.getRequestURI() %></p>
	<p>요청 서버 도메인: <%= request.getServerName() %></p>
	
	<!-- ex12_request.jsp?name=홍길동&age=22 -->
	<p>요청 쿼리 문자열: <%= request.getQueryString() %></p>
	<p>클라이언트 주소: <%= request.getRemoteAddr() %></p>
	<p>요청 방식: <%= request.getMethod() %></p>
	<p>컨텍스트 경로: <%= request.getContextPath() %></p>
	
	<p><%= request.getHeader("accept-language") %></p>
	
	<%
		//request.getHeader("헤더명")
		
		Enumeration<String> e = request.getHeaderNames();
	
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name);
		}
		
	%>
	
</body>
</html>




















