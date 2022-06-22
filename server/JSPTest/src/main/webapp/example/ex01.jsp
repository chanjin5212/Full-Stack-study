<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p {
		color: blue;
	}
</style>
</head>
<body>
	<!-- http://localhost:8090/JSPTest/ex01.jsp -->
	<h1>JSP 페이지</h1>
	<p>문단입니다.</p>
	
	
	<%
		//여기는 자바 영역입니다(= 자바 클래스 영역, 서블릿 영역과 동일)
		Calendar now = Calendar.getInstance();
	
		System.out.println(pageContext.getRequest() == request);
	
	%>
	
	<p>현재 날짜: <%= String.format("%tT", now) %></p>
	
	<%@ include file="inc/copyright.jsp" %>
	
	
</body>
</html>



















