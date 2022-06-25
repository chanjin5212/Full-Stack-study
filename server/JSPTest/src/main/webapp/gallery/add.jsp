<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<%@ include file="/gallery/inc/asset.jsp" %>
<style>
	.container {
		width: 810px;
		margin-bottom: 100px;
	}
	form {
		margin-top: 30px;
	}
	.container  .table {
		width: 750px;
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body>

	<!-- list.jsp -->
	<div class="container">
		<h1>Image Gallery <small>Add</small></h1>
				
		<form method="POST" action="addok.jsp" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required class="form-control"></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="attach" required></td>
			</tr>
		</table>
		
		<div>
			<input type="button" value=" 돌아가기 "
				class="btn btn-secondary" onclick="location.href='list.jsp';">
				
			<input type="submit" value=" 이미지 업로드 "
				class="btn btn-success">
			
		</div>
		</form>
		
		
	</div>
	
	
	
	
	
</body>
</html>
















