<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//시작 페이지를 거치지 않고 방문하는 사용자를 검사
	if (session.getAttribute("auth") == null) {
		
		//미인증 사용자
		out.print("<html>");
		out.print("<body>");
		out.print("<script>");
		out.print("alert('회원만 접근 가능합니다.');");
		out.print("location.href='index.jsp';");
		out.print("</script>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();//*** 지금까지 만든 산출물을 브라우저에게 돌려주고 이 이후의 페이지 작업은 하지 말것
	}

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
	
	<!-- member.jsp -->
	<div class="container">
	
		<h1>회원 전용</h1>
		
		<p>이 내용은 회원만 열람이 가능합니다.</p>
		
		<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='index.jsp';">
	</div>
	
	<script>
	
	</script>
	
</body>
</html>