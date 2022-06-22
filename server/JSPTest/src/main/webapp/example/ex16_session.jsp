<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	session.setAttribute("name", "홍길동");
	application.setAttribute("age", 20);
	
	//페이지 방문 횟수
	
	if (session.getAttribute("count") == null) {
		//count = 0;
		session.setAttribute("count", 0); //초기화
	} else {
		//count = count + 1;
		session.setAttribute("count", (int)session.getAttribute("count") + 1);
	}
	
	if (application.getAttribute("count") == null) {
		application.setAttribute("count", 0);
	} else {
		application.setAttribute("count", (int)application.getAttribute("count") + 1);
	}

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

	<!-- ex16_session.jsp -->
	<div class="container">
		
		<h1>application & session</h1>
		
		<div>이름: <%= session.getAttribute("name") %></div>
		<div>나이: <%= application.getAttribute("age") %></div>
		
		<h1>방문 횟수</h1>
		<div>session: <%= session.getAttribute("count") %></div>
		<div>application: <%= application.getAttribute("count") %></div>
		
		<hr>
		
		<a href="ex16_session_1.jsp">다음 페이지</a>
		
	</div>
	
	<script>
		
	</script>

</body>
</html>
















