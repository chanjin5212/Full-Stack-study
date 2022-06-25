<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	String toDo = request.getParameter("toDo");
	String priority = request.getParameter("priority");
	
	int result = 0;
	
	try {
		
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = util.open();
		
		
		String sql = "insert into tblTodo (seq, todo, priority, complete) values (seqTodo.nextVal, ?, ?, ?)";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, toDo);
		pstat.setString(2, priority);
		pstat.setString(3, "n");
		
		
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
















