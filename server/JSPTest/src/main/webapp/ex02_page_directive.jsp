<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"  %>
<%@page import="java.util.Random"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex02_page_directive.jsp -->
	
	<h1>페이지 지시자</h1>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non enim rem quasi ipsa exercitationem veniam aliquid iste doloribus explicabo dignissimos numquam accusantium atque at dicta hic. Distinctio vero commodi ratione.</p>
	<%
	
		//Random rnd = null;
		//System.out.println(rnd.nextInt()); //NullPointerException
	
	%>
	
	
	<%@ include file="inc/copyright.jsp" %>
	
	
</body>
</html>











































