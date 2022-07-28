<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/spring/resources/css/bootstrap.css">
<script src="/spring/resources/js/jquery-1.12.4.js"></script>
<style>
	main {
		width: 800px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	
	<main>
		<h1></h1>
		
		
	</main>
	

	<script>
		
		//writeok.jsp	
	
		<c:if test="${result == 1}">
		location.href = "/spring/list";
		</c:if>
		
		<c:if test="${result == 0}">
		alert('failed');
		history.back();
		</c:if>
		
	</script>
</body>
</html>















