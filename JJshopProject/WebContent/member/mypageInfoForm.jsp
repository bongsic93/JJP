<%@page import="memberDto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">

<script>
function on(){

	
	if(document.lg_frm.password.value.length < 4) {
		alert("비밀번호는  4자리 이상 입니다.");
		reg_frm.password.focus();
		return;
	}
	 
	 if(document.lg_frm.password.value.length == 0) {
			alert("변경할 비밀번호를 입력해주십시오.");
			reg_frm.password.focus();
			return;
		}
	 
	 if(document.lg_frm.password.value != document.lg_frm.password2.value ){
		 alert("비밀번호가 일치하지 않습니다.");
			reg_frm.password.focus();
	 }
	 document.lg_frm.submit();
	}
</script>
<title>마이페이지</title>
</head>
<body>

<jsp:include page="/menu.jsp"></jsp:include>
<% MemberDto memInfo = (MemberDto)request.getAttribute("memInfo"); %>
<%String contextpath = request.getContextPath(); %>

<c:set var="mem" value="<%=memInfo %>"/>



<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="post" action="<%=contextpath %>/memInfoModify.member" name="lg_frm">
					<h3 style="text-align: center;">개인정보 수정</h3>
					
					<div class="form-group">
						아이디 : <label class="form-control"><%=session.getAttribute("userID") %> </label>
					<input type="hidden" name="id" value="<%=session.getAttribute("userID") %>">
					</div>
					<div class="form-group">
						이름 : <label class="form-control">${mem.getUserName() }</label>
										<input type="hidden" name="name" value="${mem.getUserName() }">
					
					</div>
					<div class="form-group">
						비밀번호 : <input type="password" name="password" class="form-control"
							value=""><br>
					</div>
					<div class="form-group">
						비밀번호 확인 : <input type="password" class="form-control"
							name="password2"><br>
					</div>
					
					<div class="form-group">
						이메일 : <input type="text" class="form-control"
							name="Email" value="${mem.getUserEmail() }"><br>
					</div>
					<div class="form-group">
						성별 : <label class="form-control">${mem.getUserGender() }</label><br>
							<input type="hidden" name="name" value="${mem.getUserGender() }">
					
					</div>
					
					
					<input type="button" class="btn btn-primary form-control"
						value="회원 정보 변경" onclick="on()">

				</form>
			</div>
			<div class="col-lg-4"></div>
		</div>

</body>
</html>