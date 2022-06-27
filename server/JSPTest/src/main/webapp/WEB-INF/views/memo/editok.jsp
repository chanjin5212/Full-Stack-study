<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/memo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- template.jsp > addok.jsp > editok.jsp -->
	<main>
		<%@ include file="/WEB-INF/views/memo/inc/header.jsp" %>
		<section>
			
		</section>
	</main>
	
	<script>
		
		<c:if test="${result == 1}">
		location.href = '/jsp/memo/list.do';
		</c:if>
		
		
		<c:if test="${result == 0}">
		alert('수정 실패;;');
		history.back();
		</c:if>
		
	</script>
	
</body>
</html>