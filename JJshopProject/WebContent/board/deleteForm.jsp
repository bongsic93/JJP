<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
		String num = request.getParameter("num");
%>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
	<title>J&J shop</title>
</head>
<body>
	<div class="container">
		<div class="row" align="center">
		<h1><b >글 삭 제</b></h1>
		<form name="f" action="delete_pro.board" method="post">
			<input type="hidden" name="num" value="<%=num%>">
			<table  style="width: 600px;" align="center"class="table table-striped" style="text-align: center; border: 1px solid #dddddd" >
				<tr >
					<th style="background-color: #eeeeee; text-align: center;">비밀번호를 입력해 주세요</th>
				</tr>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">	비밀번호 : <input type="password" name="passwd"></th>
				</tr>
				<tr style="background-color: #eeeeee; text-align: center;">
					<td align="center">
						<input type="submit" class="btn btn-primary pull-right"value="글삭제">
						<input type="button" class="btn btn-primary pull-right"value="글목록" onclick="window.location='list.board'">
					</td>	
				</tr>
			</table>
		</form>
	</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
      <script src="js/bootstrap.js"></script>
</body>
</html>