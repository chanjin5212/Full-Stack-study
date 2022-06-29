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
	
	<!-- member > register.jsp -->
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>Register</h2>
			
			<form method="POST" action="/toy/member/registerok.do"
										enctype="multipart/form-data">
			
			<table class="table table-bordered vertical">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" class="form-control short" required></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type="password" name="pw" class="form-control short" required></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" class="form-control short" required></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="pic" class="form-control"></td>
				</tr>
			</table>
			
			<div class="btns">
				<input type="button" value="돌아가기" class="btn btn-secondary"
					onclick="location.href='/toy/index.do';">
				<button class="btn btn-primary">
					<i class="fas fa-marker"></i>
					등록하기
				</button>
				
			</div>
			
			</form>
			
		</section>
	</main>
	
	<script>
		
	</script>

</body>
</html>


















