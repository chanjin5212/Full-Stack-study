<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");
	
	String path = application.getRealPath("/gallery/images");
	int size = 1024 * 1024 * 100; //100MB
	
	String filename = "";
	
	int result = 0;
	
	try {
		
		MultipartRequest multi = new MultipartRequest(
			  	request, 
			  	path,	 
			  	size, 	 
			  	"UTF-8", 
			  	new DefaultFileRenamePolicy() 
			 );
		
		//업로드한 이미지명 > DB 저장
		String subject = multi.getParameter("subject");
		filename = multi.getFilesystemName("attach");
		DBUtil util = new DBUtil();
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = util.open();
		
		
		String sql = "insert into tblGallery (seq, filename, subject) values (seqGallery.nextVal, ?, ?)";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, filename);
		pstat.setString(2, subject);
		
		
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
			
			alert('추가 실패;;');
			history.back();
			
		<% } %>
	</script>
	
</body>
</html>
















