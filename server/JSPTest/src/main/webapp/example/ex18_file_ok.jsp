<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	//<form enctype="multipart/form-data">
	//- request.getParameter() 동작 불능
	//- request.getParameterValues() 동작 불능
	//- cos.jar > MultipartRequest 대신 사용
	
	//String txt = request.getParameter("txt");
	//String num = request.getParameter("num");
	
	//MultipartRequest
	//1. request > Wrapping Class > request 역할을 그대로 구현
	//2. 파일 업로드 처리 구현
	
	
	
	//업로드될 파일들이 위치할 폴더의 (로컬)경로: webapp > example > files
	//String path = "D:\\class\\server\\JSPTest\\src\\main\\webapp\\example\\files";
	String path = application.getRealPath("/example/files");
	
	//D:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\example\files
	
	//아파치 톰캣이 실제 서버를 운영하기 위해서 원본 소스를 복사해놓은 실제 운영 디렉토리(***)
	
	//System.out.println(path);
	
	
	//업로드 파일의 최대 크기 지정(제한)
	//- 바이트 단위
	int size = 1024 * 1024 * 100; //100MB
	
	
	//변수 선언
	String txt = ""; 		//문자열
	String num = ""; 		//숫자
	String filename = "";	//첨부파일명
	String orgfilename = "";//첨부파일명
	
	try {
		
		//request > MultipartRequest
		//com.oreilly.servlet.MultipartRequest
		
		//MultipartRequest 객체를 만드는 순간 이미 첨부파일은 files 폴더에 업로드가 완료되어 있음.
		MultipartRequest multi = new MultipartRequest(
								  	request, //원래의 request 객체
								  	path,	 //업로드 위치
								  	size, 	 //최대 크기
								  	"UTF-8", //인코딩 지정
								  	new DefaultFileRenamePolicy() //파일명 관리 객체
								 );
		
		
		//전송 데이터 가져오기
		//txt = request.getParameter("txt");
		txt = multi.getParameter("txt");
		num = multi.getParameter("num");
		
		//파일 정보 가져오기
		//<input type="file" name="attach">
		filename    = multi.getFilesystemName("attach"); //하드 디스크에 저장된 진짜 이름
		orgfilename = multi.getOriginalFileName("attach"); //사용자 올리 원본 이름
		
		
	} catch(Exception e) {
		System.out.println(e);		
	}
	
	
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

	<!-- ex18_file_ok.jsp -->
	<div class="container">
		<h1>결과</h1>
		
		<div class="well">
			<strong>문자열</strong>
			<%= txt %>
		</div>
		
		<div class="well">
			<strong>숫자</strong>
			<%= num %>
		</div>
		
		<div class="well">
			<strong>파일</strong>
			<%= filename %>, <%= orgfilename %>
		</div>
		
		<h2>파일 다운로드</h2>
		
		<div><a href="/jsp/example/files/<%= filename %>"><%= filename %></a></div>
		
		<div><a href="/jsp/example/files/<%= filename %>" download><%= filename %></a></div>
		
		<div><a href="ex17_session.jsp" download>세션 페이지</a></div>
		
		<div><a href="download.jsp?filename=<%= filename %>&orgfilename=<%= orgfilename%>"><%= orgfilename %></a></div>
		
	</div>
	
	<script>
		
	</script>

</body>
</html>
















