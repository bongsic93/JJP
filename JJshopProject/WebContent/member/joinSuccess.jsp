<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>회원가입 성공</title>
</head>
<body>


<jsp:include page="/menu.jsp"></jsp:include>


<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h1>가입 성공</h1>
				<p>서비스를 이용하시려면 로그인 해주세요.</p>
				<p>
					<a class="btn btn-primary btn-pull" href="loginForm.jsp" role="button">로그인</a>
				</p>
			</div>
		</div>
	</div>


</body>
</html>