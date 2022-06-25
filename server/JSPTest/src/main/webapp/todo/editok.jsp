<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	String seq = request.getParameter("seq");
	String complete = request.getParameter("complete");
	
	int result = 0;
	
	try {
		
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = DBUtil.open();
		
		
		String sql = "update tblTodo set complete = ? where seq = ?";
		
		pstat = conn.prepareStatement(sql);
		if (complete.equals("n")) {
			pstat.setString(1, "y");
		} else {
			pstat.setString(1, "n");
		}
		pstat.setString(2, seq);
		
		
		
		result = pstat.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>
<%@ include file="/todo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<main>
		
	</main>
	
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
















