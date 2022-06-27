<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/auth/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- login.jsp -->
	<div class="container">
		
		<h1>로그인</h1>
		
		<form method="POST" action="loginok.jsp">
			<table class="table table-bordered" style="width: 300px">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" class="form-control" required></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type="password" name="pw" class="form-control" required /></td>
				</tr>
			</table>
			<div class="btns">
				<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='index.jsp';">
				<input type="submit" value="로그인" class="btn btn-primary">
			</div>
		</form>
		
	</div>
	
	<script>
	
	</script>
	
</body>
</html>












