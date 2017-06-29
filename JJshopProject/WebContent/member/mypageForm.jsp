<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/menu.jsp"></jsp:include>


<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
			
					<h3 style="text-align: center;">마이 페이지 항목</h3>
					<br>
					<div class="form-group">
						
				<input type="button" class="btn btn-primary form-control"
						value="회원 정보 변경하기" onclick="location.href='mypageInfoForm.member';">
					</div>
					
					<div class="form-group">
						
				<input type="button" class="btn btn-primary form-control"
						value="주문 조회" onclick="location.href='#';">
					</div>
					
					<div class="form-group">
						
				<input type="button" class="btn btn-primary form-control"
						value="장바구니" onclick="location.href='#';">
					</div>
				
					
					

				
			</div>
			<div class="col-lg-4"></div>
		</div>
</body>
</html>