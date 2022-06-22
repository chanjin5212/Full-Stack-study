<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//JDBC > select > 결과셋 > 화면 출력

	ArrayList<String> list = new ArrayList<String>();
	
	list.add("홍길동");
	list.add("아무개");
	list.add("하하하");
	list.add("호호호");
	list.add("후후후");
	
	
	ArrayList<String> color = new ArrayList<String>();
	
	color.add("tomato");
	color.add("gold");
	color.add("cornflowerblue");
	color.add("yellowgreen");
	color.add("magenta");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.item {
		border: 1px solid #AAA;
		border-radius: 5px;
		padding: 15px;
		width: 450px;
		margin-bottom: 10px;
	}

</style>
</head>
<body>
	<!-- ex07_script.jsp -->
	
	<h1>Memeber</h1>
	
	<% for(int i=0; i<list.size(); i++) { %>
	
	<div class="item" style="background-color: <%= color.get(i) %>;">
		<h2><%= list.get(i) %></h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique aperiam voluptates minus rerum provident debitis beatae quidem vitae est voluptate quam nisi esse ab maiores recusandae. Doloribus aut dolore labore.</p>
		<input type="button" value="자세히보기" class="btn" 
						onclick="info('<%= list.get(i) %>');">
	</div>
	
	<% } %>
	
	<script>
	
		function info(name) {
			alert('회원:' + name);
			//alert(``);
		}
	
	</script>
	
</body>
</html>






































