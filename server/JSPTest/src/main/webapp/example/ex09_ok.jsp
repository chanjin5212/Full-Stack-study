<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//클라이언트 > (데이터 전송) > 서버
	//1. GET
	//	- URL에 붙여서 전송 > 톰캣 관련
	//	- UTF-8 동작
	//	- <form method="GET"> 경우가 적음
	//	- 링크, location > URL 사용하는 경우
	
	
	//ex09_ok.jsp?txt=홍길동&num=123
	//- ex09_ok.jsp > 페이지 주소
	//- ? > 이후부터 전송 데이터입니다.(구분자)
	//- txt=홍길동&num=123 > 전송 데이터
	//	- txt=홍길동 > key=value
	//	- & > 구분자
	//	- num=123
			
	//?txt=홍길동&num=123
	// > QueryString(***)
	
	
	
	
	//2. POST
	//	- 패킷 본문에서 전송
	//	- ISO-8859-1 동작
	//	- <form method="POST">
	
	

	//수신되는 데이터의 인코딩 처리하기
	// > 이후에 request.getParameter()가 UTF-8로 동작한다.
	//request.setCharacterEncoding("UTF-8");


	//데이터 수신하기
	//- String request.getParameter(String key)
	//	클라이언트 > 서버로 전송된 모든 데이터를 수신한다.
	String txt = request.getParameter("txt");
	String num = request.getParameter("num");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form > div {
		margin-bottom: 5px;
	}
</style>
</head>
<body>
	<!-- ex09_ok.jsp -->
	<h1>결과</h1>
	
	<div>
		문자: <%= txt %>
	</div>
	<div>
		문자: <%-- <%= txt.length() %> --%>
	</div>
	<div>
		숫자: <%= num %>
	</div>
	
</body>
</html>


















