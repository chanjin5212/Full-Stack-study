<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//삭제할 이미지명 가져오기
	String filename = request.getParameter("filename");

	//파일 삭제
	//System.out.println(filename);
	
	String path = application.getRealPath("/example/images");
	
	File img = new File(path + "/" + filename);
	
	img.delete();
	
	response.sendRedirect("ex20_file_form.jsp");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- ex20_file_delete.jsp -->
	<div class="container">
	
	</div>
	
	<script>
	
	</script>
	
</body>
</html>