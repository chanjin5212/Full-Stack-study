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
	.btns {
		margin-top: 20px;
	}
</style>
</head>
<body>

	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			
			<h2>Unregister</h2>
			
			<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem quisquam molestiae placeat id illum aliquid accusantium assumenda inventore iure error natus neque excepturi cum aspernatur eum. Ad quasi recusandae velit!</div>
			
			<div class="btns">
				<input type="button" value="돌아가기" class="btn btn-secondary"
					onclick="location.href='/toy/index.do';">
				
				<button class="btn btn-danger"
					onclick="location.href='/toy/member/unregisterok.do';">
					<i class="fas fa-sign-out-alt"></i>
					탈퇴하기
				</button>
			</div>
			
		</section>
	</main>
	
	<script>
		
	</script>

</body>
</html>


















