<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>JSP 게시판 웹 사이트</title>
</head>
<%
		int num=0, re_step=0, re_level=0;
		String snum = request.getParameter("num");
		if (snum != null){//답글에서 왔느냐...
			num = Integer.parseInt(snum);
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}
%>
<body>
<%
   String userID = null;
if(session.getAttribute("userID") != null){
   userID = (String)session.getAttribute("userID");
}

%>

<jsp:include page="/menu.jsp"></jsp:include>
 	  <div class = "contaniner">
 	  	<div class="row">
 	  		<form name="f" method="post" action="write_pro.board"
 	  		method="post" enctype="multipart/form-data">
 	  		<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="re_step" value="<%=re_step%>">
			<input type="hidden" name="re_level" value="<%=re_level%>">
 	  		<table style="width: 600px;" class ="table table-striped" style="text-align: center; border:1px solid #dddddd " align="center">
 	  			<thead>
 	  				<tr >
 	  					<th  colspan="2"style="background-color:#eeeeeee; text-align:center;">게시판글쓰기양식</th>
 	  				</tr>
 	  			</thead>
 	  			<tbody>
 	  				<tr>
					<td><input type="text" name="writer"  class="form-control"placeholder="이름" maxlength="5" value="<%=userID%>"readOnly></td>
				</tr>		
				<tr>
					<td><input type="text" name="subject" class="form-control"placeholder="제목"></td>
				</tr>		
				<tr>
					<td><input  type="text" name="email"class="form-control"placeholder="Email"></td>
				</tr>
				<tr>
					<td><textarea name="content"rows="10" cols="80" class="form-control"placeholder="내용"></textarea></td>
				</tr>
				<tr>
					<td><input  type="file" name="filename" class="form-control"placeholder="파일이름"></td>
				</tr>
				<tr>
					<td><input  type="password" name="passwd"class="form-control"placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글쓰기"class="btn btn-primary pull-right">
						<input type="reset" value="다시작성"class="btn btn-primary pull-right">
						<input type="button" value="목록보기" class="btn btn-primary pull-right"onclick="window.location='list.board'">
					</td>
				</tr>
 	  			</tbody>
 	  		</table>
 	  		</form> 	  		
 	  	</div>
 	  </div>
</body>
</html>