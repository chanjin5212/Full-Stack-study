<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	DBUtil util = new DBUtil();
	
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	conn = util.open();
	
	String sql = "select * from tblTodo order by regdate";
	
	stat = conn.createStatement();
	
	rs = stat.executeQuery(sql);

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
		<h1>Todo <small>List</small></h1>
		
		<table class="table table-bordered list">
			<tr>
				<th>★</th>
				<th>할일</th>
				<th>날짜</th>
			</tr>
			<% while(rs.next()) { 
				if (rs.getString("complete").equals("n")) {
			%>
					<tr>
						<td><%= rs.getString("priority") %></td>
						<td onclick="location.href='editok.jsp?seq=<%= rs.getString("seq") %>&complete=<%= rs.getString("complete") %>'"><%= rs.getString("todo") %></td>
						<td><%= rs.getString("regdate") %></td>
					</tr>
				<% } else { %>
					<tr class="complete">
						<td><%= rs.getString("priority") %></td>
						<td onclick="location.href='editok.jsp?seq=<%= rs.getString("seq") %>&complete=<%= rs.getString("complete") %>'"><%= rs.getString("todo") %></td>
						<td><%= rs.getString("regdate") %></td>
					</tr>
				<% } %>
			<% } %>

		</table>
		
		<div class="btns">
			<input type="button" value="등록하기"
				class="btn btn-warning" onclick="location.href='add.jsp';">
		</div>
	</main>
	
	<script>
		
		
	</script>

</body>
</html>
















