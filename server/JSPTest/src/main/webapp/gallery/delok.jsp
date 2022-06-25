<%@page import="java.io.File"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String filename = request.getParameter("filename");
	String seq = request.getParameter("seq");

	String path = application.getRealPath("/gallery/images");
	
	File img = new File(path + "/" + filename);
	
	img.delete();
	
	int result = 0;
	
	try {
			
		DBUtil util = new DBUtil();
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = util.open();
		
		
		String sql = "delete from tblGallery where seq = ?";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, seq);
		
		result = pstat.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println(e);
	}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<%@ include file="/gallery/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<!-- list.jsp -->
	<div class="container">	
	</div>
	
	<script>
		<% if (result > 0) { %>
		
			location.href = 'list.jsp';
		
		<% } else { %>
			
			alert('삭제 실패;;');
			history.back();
			
		<% } %>
	</script>
	
</body>
</html>
















