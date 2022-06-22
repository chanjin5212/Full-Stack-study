<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- inc > asset.jsp -->

<!--  


	물리 경로(실제 서버의 상태)
	- webapp(공유 폴더) > ex01.jsp

	외부 환경 > 경로(다른 사람(브라우저)가 보는 상태
	- http://localhost:8090/JSPTest/ex01.jsp





	JSP 페이지 + HTML 태그 > 자원 경로(URL)
	1. 상대경로
	2. 절대경로
		- '/' > 'http://localhost:8090'
		- '/JSPTest' > webapp

-->

<!-- 
<link rel="stylesheet" href="../css/bootstrap.css" /> 
-->

<link rel="stylesheet" 
	   href="<%= request.getContextPath() %>/example/css/bootstrap.css" />
<script src="<%= request.getContextPath() %>/example/js/jquery-1.12.4.js"></script>
<script src="<%= request.getContextPath() %>/example/js/bootstrap.js"></script>



























