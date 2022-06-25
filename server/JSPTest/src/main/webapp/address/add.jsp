<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<%@include file="/address/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- template.jsp > add.jsp -->
	<main>
		<header>
			<%@ include file ="inc/header.jsp" %>
		</header>
		<section>
			<div class="section content">
				
				<form method="POST" action="addok.jsp">
					<table class="table table-bordered">
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" required class="form-control short"></td>						
						</tr>
						<tr>
							<th>나이</th>
							<td><input type="number" name="age" required min="18" max="120" class="form-control short"></td>						
						</tr>
						<tr>
							<th>성별</th>
							<td>
								<select name="gender" class="form-control short">
									<option value="m">남자</option>
									<option value="f">여자</option>
								</select>
							</td>						
						</tr>
						<tr>
							<th>전화</th>
							<td><input type="text" name="tel" required class="form-control middle"></td>						
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" name="address" required class="form-control"></td>						
						</tr>
					</table>
					
					<div class="btns">
						<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/jsp/address/list.jsp';">
						<input type="submit" value="추가하기" class="btn btn-primary">
					</div>
				</form>
				
			</div>
		</section>
	</main>
	
	<script>
	
	</script>
	
</body>
</html>