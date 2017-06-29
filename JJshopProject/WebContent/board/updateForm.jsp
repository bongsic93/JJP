<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.*"%>
<html>
<head>
	<title>게시판</title>
</head>
<%	BoardDBBean dto = (BoardDBBean)request.getAttribute("getBoard"); %>
<body>
<%String contextpath = request.getContextPath(); %>
	<%
	
   String userID = null;
if(session.getAttribute("userID") != null){
   userID = (String)session.getAttribute("userID");
}

%>

			<%
          if(userID == null){
         %>
         
<jsp:include page="/menu.jsp"></jsp:include>
 	  <div class = "contaniner">
 	  	<div class="row">		
 	  	<form name="f" action="update_pro.board" method="post">
			<input type="hidden" name="num" value="<%=dto.getNum()%>">
			<table style="width: 600px;" class ="table table-striped" style="text-align: center; border:1px solid #dddddd " align="center">
				<tr >
					<th colspan="2">글수정</th>
				</tr>
				<tr>
					<th >이름</th>
					<td><input type="text" class="form-control"name="writer" value="<%=userID%>"></td>
				</tr>		
				<tr>
					<th >제목</th>
					<td><input type="text"class="form-control" name="subject" value="<%=dto.getSubject()%>"></td>
				</tr>		
				<tr>
					<th >Email</th>
					<td><input type="text" class="form-control"name="email" value="<%=dto.getEmail()%>"></td>
				</tr>
				<tr>
					<th >내용</th>
					<td><textarea name="content"class="form-control" rows="10" cols="80"><%=dto.getContent()%></textarea></td>
				</tr>
				<tr>
					<th >비밀번호</th>
					<td><input type="password"class="form-control" name="passwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글수정"class="btn btn-primary pull-right">
						<input type="reset" value="다시작성"class="btn btn-primary pull-right">
						<input type="button" value="목록보기" class="btn btn-primary pull-right"onclick="window.location='list.board'">
					</td>
				</tr>
			</table>
		</form>
		<%} %>
	</div>
	</div>
</body>
</html>