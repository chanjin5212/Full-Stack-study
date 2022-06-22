<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//1. 데이터 가져오기
	//2. 업무 처리
	//3. 결과 출력
	
	//1.
	request.setCharacterEncoding("UTF-8");

	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String text = request.getParameter("text");
	String backgroundcolor = request.getParameter("backgroundcolor");
	String color = request.getParameter("color");
	String fontsize = request.getParameter("fontsize");
	int count = Integer.parseInt(request.getParameter("count"));
	String leftright = request.getParameter("leftright");
	String topbottom = request.getParameter("topbottom");
	String icon = request.getParameter("icon");
	String isborder = request.getParameter("isborder");
	String borderwidth = request.getParameter("borderwidth");
	String bordercolor = request.getParameter("bordercolor");
	String borderstyle = request.getParameter("borderstyle");
	String borderradius = request.getParameter("borderradius");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="js/jquery-1.12.4.js"></script>
<style>
	
	#tbl { width: 600px; }
	#tbl th, #tbl td { text-align: center; }
	#tbl td { padding: 50px; }
	
	.button {
		 
		width: <%= width %>px;
		height: <%= height %>px;
		background-color: <%= backgroundcolor %>;
		color: <%= color %>;
		font-size: <%= fontsize %>px;
		margin: <%= topbottom %>px <%= leftright %>px;
		
		<% if (isborder.equals("n")) { %>
			border: 0;
		<% } else { %>
			border: <%= borderwidth %>px <%= bordercolor %> <%= borderstyle %>;
			border-radius: <%= borderradius %>px;
		<% } %>
		
	}
	
</style>
</head>
<body>
	<!-- ex11_ok.jsp -->
	<div class="container">
		<h1>결과</h1>
		
		<table id="tbl" class="table table-bordered">
			<tr>
				<th>버튼</th>
			</tr>
			<tr>
				<td>
					<%-- 
					<button class="button" style="width:<%= width %>px;height:<%= height %>px;">Button</button> 
					--%>
					<%-- 
					<button class="button"><%= text %></button> 
					--%>
					<!-- 
					<button class="button">
						<span class="glyphicon glyphicon-heart"></span>
						Button
					</button> 
					-->
					<% for (int i=0; i<count; i++) { %>
						<button class="button">
							<% if (!icon.equals("none")) { %>
								<span class="<%= icon %>"></span>
							<% } %>
							<%= text %>
						</button>
					<% } %>
				</td>
			</tr>
		</table>		
	</div>
	
	<script>
	
		//$(".button").css("width", "<%= width %>px");
		//$(".button").css("height", "<%= height %>px");
		//$(".button").text('<%= text %>');
		
		/* 
		$(".button").css({
			"width": "100px",
			"height": "100px"
		}); 
		*/
	
	</script>
</body>
</html>











