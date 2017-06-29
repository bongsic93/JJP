<%@page import="memberDto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<script>
function on(){

	
	if(document.lg_frm.password.value.length < 4 &&  document.lg_frm.password.value.length > 0) {
		alert("비밀번호는  4자리 이상 입니다.");
		reg_frm.password.focus();
		return;
	}
	 
	 if(document.lg_frm.password.value.length == 0) {
			alert(" 비밀번호를 입력해주십시오.");
			reg_frm.password.focus();
			return;
		}
	 
	
	 document.lg_frm.submit();
	}


</script>


<jsp:include page="/menu.jsp"></jsp:include>

<%String id = request.getParameter("id"); %>
<%String contextpath = request.getContextPath(); %>



<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="post" action="<%=contextpath %>/mypageCheck.member" name="lg_frm">
					<h3 style="text-align: center;">본인 확인 </h3>
					
					
					
					<div class="form-group">
						 <input type="password" name="password" class="form-control"
							placeholder="비밀번호">
							<input type="hidden" name = "id" value="<%=id%>">
					</div>
					
					
					
					<input type="button" class="btn btn-primary form-control"
						value="회원 정보 변경" onclick="on()">

				</form>
			</div>
			<div class="col-lg-4"></div>
		</div>


</body>
</html>