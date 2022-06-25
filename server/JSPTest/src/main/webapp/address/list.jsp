<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//1. DB 작업 > select > 결과
	//2. 결과 출력 > 테이블
	
	//1.
	DBUtil util = new DBUtil();
	
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	conn = util.open();
	
	String sql = "select * from tblAddress order by name asc";
	
	stat = conn.createStatement();
	
	rs = stat.executeQuery(sql);
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<%@include file="/address/inc/asset.jsp" %>
<style>
	th:nth-child(1) { width: 80px; }
	th:nth-child(2) { width: 60px; }
	th:nth-child(3) { width: 70px; }
	th:nth-child(4) { width: 120px; }
	th:nth-child(5) { width: auto; }
	th:nth-child(6) { width: 100px; }
	
	td:nth-child(6) > span:hover { cursor: pointer; color: cornflowerblue; }
</style>
</head>
<body>
	
	<!-- template.jsp > list.jsp -->
	<main>
		<header>
			<%@ include file ="inc/header.jsp" %>
		</header>
		<section>
			<div class="section content">
				
				<table class="table table-bordered">
					<tr>
						<th>이름</th>
						<th>나이</th>
						<th>성별</th>
						<th>전화</th>
						<th>주소</th>
						<th>조작</th>
					</tr>
					<% while (rs.next()) { %>
					<tr>
						<td><%= rs.getString("name") %></td>
						<td><%= rs.getString("age") %></td>
						<td><%= rs.getString("gender").equals("m") ? "남자" : "여자" %></td>
						<td><%= rs.getString("tel") %></td>
						<td><%= rs.getString("address") %></td>
						<td>
							<span onclick="location.href='edit.jsp?seq=<%= rs.getString("seq") %>';">[수정]</span>
							<span onclick="location.href='del.jsp?seq=<%= rs.getString("seq") %>';">[삭제]</span>
						</td>
					</tr>
					<% } %>
				</table>
				
				<div class="btns">
					<input type="button" value="추가하기" class="btn btn-primary" onclick="location.href='add.jsp';">
				</div>
			
				
			</div>
		</section>
	</main>
	
	<script>
		
	
	</script>
	
</body>
</html>