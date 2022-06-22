<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="js/jquery-1.12.4.js"></script>
<style>

	table div {
		margin: 7px 0;
	}	

	#tbl { width: 600px; }
	#tbl th { width: 120px; text-align: center; }
	#tbl td { width: 480px; }
	
	.tiny { width: 60px }
	.sm { width: 120px; }
	.md { width: 250px; }
	.right { text-align: right; }
	.inline { display: inline; }
	
	input[type=radio]+span {
		margin-right: 10px;
	}
	
	#borderbox {
		display: none;
	}
	 
</style>
</head>
<body>
	<!-- ex11_form.jsp -->
	<div class="container">
		
		<h1>버튼 만들기</h1>
		
		<form method="POST" action="ex11_ok.jsp">
			<table id="tbl" class="table table-bordered">
				<tr>
					<th>너비(px)</th>
					<td>
						<input type="number" name="width" min="20" max="300" step="10" value="60" class="form-control sm right">
					</td>
				</tr>
				<tr>
					<th>높이(px)</th>
					<td>
						<input type="number" name="height" min="10" max="200" step="10" value="30" class="form-control sm right">
					</td>
				</tr>
				<tr>
					<th>텍스트</th>
					<td>
						<input type="text" name="text" class="form-control md" value="Button">
					</td>
				</tr>
				<tr>
				<th>배경색</th>
				<td><input type="color" name="backgroundcolor" value="#FFFFFF" class="form-control tiny"></td>
			</tr>
			<tr>
				<th>글자색</th>
				<td><input type="color" name="color" value="#000000" class="form-control tiny"></td>
			</tr>
			<tr>
				<th>글자 크기(px)</th>
				<td><input type="number" name="fontsize" min="10" max="100" value="16" class="form-control sm right"></td>
			</tr>
			<tr>
				<th>버튼 개수(ea)</th>
				<td><input type="number" name="count" min="1" max="30" value="1" class="form-control sm right"></td>
			</tr>
			<tr>
				<th>버튼 간격</th>
				<td>
					<div>좌우 간격 : <input type="range" min="0" max="50" value="0" name="leftright"></div>
					<div>상하 간격 : <input type="range" min="0" max="50" value="0" name="topbottom"></div>
				</td>
			</tr>
			<tr>
				<th>아이콘</th>
				<td>
					<input type="radio" name="icon" value="none" checked> 없음
					<input type="radio" name="icon" value="glyphicon glyphicon-heart"> <span class="glyphicon glyphicon-heart"></span>
					<input type="radio" name="icon" value="glyphicon glyphicon-headphones"> <span class="glyphicon glyphicon-headphones"></span>
					<input type="radio" name="icon" value="glyphicon glyphicon-camera"> <span class="glyphicon glyphicon-camera"></span>
					<input type="radio" name="icon" value="glyphicon glyphicon-facetime-video"> <span class="glyphicon glyphicon-facetime-video"></span>
					<input type="radio" name="icon" value="glyphicon glyphicon-magnet"> <span class="glyphicon glyphicon-magnet"></span>
				</td>
			</tr>
			<tr>
				<th>테두리</th>
				<td>
					<select name="isborder" id="isborder" class="form-control sm">
						<option value="n">감추기</option>
						<option value="y">보이기</option>
					</select>
					<div id="borderbox" class="well">
						<div>두께(px) : <input type="number" name="borderwidth" min="0" max="10" value="1" class="form-control sm inline right"></div>
						<div>색상 : <input type="color" name="bordercolor" value="#000000" class="form-control sm inline"></div>
						<div>
							스타일 :
							<select name="borderstyle" class="form-control sm inline">
								<option value="solid">실선</option>
								<option value="dashed">쇄선</option>
								<option value="dotted">점선</option>
							</select>	
						</div>
						<div>
							모서리(px) : <input type="number" name="borderradius" min="0" max="50" value="0" class="form-control sm inline right">
						</div>
					</div>
				</td>
			</tr>
			</table>
			<div>
				<input type="submit" value="만들기"
					class="btn btn-success">
			</div>
		</form>
		
	</div>
	<script>
		$("#isborder").change(function() {
			if ($(this).val() == "y") {
				$("#borderbox").show();
			} else {
				$("#borderbox").hide();
			}
		});
	</script> 	
</body>
</html>













