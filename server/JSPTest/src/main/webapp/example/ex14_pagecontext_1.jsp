<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//System.out.println(pageContext.getRequest() == request);
	//System.out.println(pageContext.getResponse() == response);
	
	//response.sendRedirect() vs pageContext.forward()
	//- 페이지 이동 메소드
	
	
	
	//업무 코드
	int num = 10;
	
	//페이지간에 데이터를 전달하는 방법
	//1. <form>
	//2. QueryString
 	//3. 내장 객체 > 컬렉션 사용(***)
 	
 	//- pageContext, request, session, application > 객체 내부에 사용자 정의 데이터를 저장하는 컬렉션을 가지고 있다.
 	
 	
	request.setAttribute("num", num); //저장
	
	//서버쪽에서 페이지간에 데이터를 전달하려면..
	//1. request에 데이터를 저장한다.
	//2. pageContext.forward()로 이동한다.
		
	//response.sendRedirect("ex14_pagecontext_2.jsp");
	// > http://localhost:8090/JSPTest/example/ex14_pagecontext_2.jsp
	
	//이동할때 사용중이었던 request, response를 같이 전달한다.
	//- 이동한 페이지는 새롭게 request, response를 만들지 않고 이전 페이지로부터 전달받아 사용한다.
	pageContext.forward("ex14_pagecontext_2.jsp");
	// > http://localhost:8090/JSPTest/example/ex14_pagecontext_1.jsp

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<!-- ex14_pagecontext_1.jsp -->
	<div class="container">
		<h1>1번 페이지</h1>
	</div>
	
	<script>
		
	</script>

</body>
</html>
















