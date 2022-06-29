<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			
			<h2>Board</h2>
			
			<form method="POST" action="/toy/board/delok.do">
						
			<div style="margin-bottom: 15px;">삭제하시겠습니까?</div>
						
			<div class="btns">
				<input type="button" value="돌아가기" class="btn btn-secondary"
					onclick="location.href='/toy/board/view.do?seq=${seq}';">
				<button class="btn btn-primary">
					<i class="fas fa-pen"></i>
					삭제하기
				</button>
			</div>
			
			<input type="hidden" name="seq" value="${seq}">
			
			</form>
			
			
		</section>
	</main>
	
	<script>
		
	</script>

</body>
</html>


















