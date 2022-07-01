<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			
			<h2>Board</h2>
			
			<form method="POST" action="/toy/board/editok.do" enctype="multipart/form-data">
			
			<table class="table table-bordered vertical">
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" class="form-control" required value="${dto.subject}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" class="form-control" required>${dto.content}</textarea></td>
				</tr>
				<tr>
					<th>파일</th>
					<td>
						<input type="file" name="attach" class="form-control">
						
						<div style="margin: 7px 12px 3px 12px;">
						<c:if test="${not empty dto.orgfilename}">
						파일명: <span id="filename">${dto.orgfilename}</span><span onclick="delfile();" style="cursor:pointer;">&times;</span>
						</c:if>
						
						<c:if test="${empty dto.orgfilename}">
						<div>파일명: 파일 없음</div>
						</c:if>
						</div>
						
					</td>
				</tr>
			</table>
			
			<div class="btns">
				
				<!--  
				
					location.href > 서버에 항상 페이지를 요청
					history.back() > 서버와 통신없이 클라이언트가 이전에 보고 있는 페이지를 그대로 복구해서 이동
				
				-->
			
			
				<%-- <input type="button" value="돌아가기" class="btn btn-secondary"
					onclick="location.href='/toy/board/view.do?seq=${dto.seq}';"> --%>
				<input type="button" value="돌아가기" class="btn btn-secondary"
					onclick="history.back();">
				<button class="btn btn-primary">
					<i class="fas fa-pen"></i>
					수정하기
				</button>
			</div>

			<input type="hidden" name="seq" value="${dto.seq}">
			
			<input type="hidden" name="isSearch" value="${isSearch}">
			<input type="hidden" name="column" value="${column}">
			<input type="hidden" name="word" value="${word}">
			
			<input type="hidden" name="delfile" value="n" />
			
			
			</form>
			
			
		</section>
	</main>
	
	<script>
		
		function delfile() {
			if ($('#filename').css('text-decoration') .indexOf('line-through') == -1) {
				$('#filename').css('text-decoration', 'line-through');	
				$('input[name=delfile]').val('y');
			} else {
				$('#filename').css('text-decoration', 'none');
				$('input[name=delfile]').val('n');
			}
		}
	
	</script>

</body>
</html>


















