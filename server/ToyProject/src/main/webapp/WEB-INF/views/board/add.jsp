<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/toy/asset/css/tagify.css" />
<script src="/toy/asset/js/jQuery.tagify.min.js"></script>
<style>
.tags-look .tagify__dropdown__item{
  display: inline-block;
  border-radius: 3px;
  padding: .3em .5em;
  border: 1px solid #CCC;
  background: #F3F3F3;
  margin: .2em;
  font-size: .85em;
  color: black;
  transition: 0s;
}
 
.tags-look .tagify__dropdown__item--active{
  color: black;
}
 
.tags-look .tagify__dropdown__item:hover{
  background: lightyellow;
  border-color: gold;
}
</style>
</head>
<body>

	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			
			<h2>Board</h2>
			
			<form method="POST" action="/toy/board/addok.do" enctype="multipart/form-data">
			
			<table class="table table-bordered vertical">
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" class="form-control" required></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" class="form-control" required></textarea></td>
				</tr>
				<tr>
					<th>파일</th>
					<td><input type="file" name="attach" class="form-control"></td>
				</tr>
				<tr>
					<th>태그</th>
					<td><input type="text" name="tags" class="form-control" /></td>
				</tr>
			</table>
			
			<div class="btns">
				<input type="button" value="돌아가기" class="btn btn-secondary"
					onclick="location.href='/toy/board/list.do';">
				<button class="btn btn-primary">
					<i class="fas fa-pen"></i>
					쓰기
				</button>
			</div>
			
			<input type="hidden" name="reply" value="${reply}">
			<input type="hidden" name="thread" value="${thread}" />
			<input type="hidden" name="depth" value="${depth}" />
			
			</form>
			
			
		</section>
	</main>
	
	<script>
	
		
		
		const obj = {
	         dropdown: {
	            classname: 'tags-look',
	            enabled: 0,
	            closeOnSelect: false
	         }
	      };
	   
	      let temp = [];
	      
	      <c:forEach items="${taglist}" var="tag">
	         temp.push('${tag}');
	      </c:forEach>
	      
	      obj.whitelist = temp;
		
		$('input[name=tags]').tagify(obj);
		
		
		
		//JSON > JavaScript Object Notation
		
		//JavaScript Object
		/*
		const o1 = {
			name: "홍길동",
			age: 20,
			hello: function() {
				alert("안녕");
			}
		};
		
		//JSON Object(= DTO 개념)
		//- 데이터 전달용 상자 역할
		//- 프로퍼티명 > 따옴표 필수
		//- 따옴표 > 쌍따옴표
		//- 메소드 추가 불가능
		const o2 = {
			"name": "홍길동",
			"age": 20
		}
		*/
	
	</script>

</body>
</html>


















