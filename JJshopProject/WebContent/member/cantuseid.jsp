<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>아이디 중복 알림 창</title>
<script>
function re(){
	window.opener.reg_frm.checkuse.value = 'false';
	window.opener.reg_frm.id.value = "";
	window.opener.reg_frm.id.focus();
	window.open('about:blank','_parent').parent.close();
	
}


</script>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>




<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
			
					<h5 style="text-align: center;">[<%=request.getParameter("id")%>]아이디는 <br>
이미 사용중인 아이디입니다.</h5>
					<br>
					<div class="form-group">
						
				<input type="button" class="btn btn-primary form-control"
						value="다시 입력하기" onclick="re()">
					</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
</body>
</html>