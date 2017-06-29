<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.*"%>
<!-- content.jsp -->
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
	<title>글내용</title>
</head>
<%		BoardDBBean dto = (BoardDBBean)request.getAttribute("getBoard"); %>
<body>
<%
String Wuser = dto.getWriter();
String userID = null;
if(session.getAttribute("userID") != null){
   userID = (String)session.getAttribute("userID");
}

System.out.println(Wuser);
%>
<jsp:include page="/menu.jsp"></jsp:include>
	<div class="container">
			 <div class="row">
		<b>글내용 보기</b>
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
			<tr>
				<th style="background-color: #eeeeee; text-align: center;">글번호</th>
				<td align="center"><%=dto.getNum()%></td>
				<th style="background-color: #eeeeee; text-align: center;">조회수</th>
				<td align="center"><%=dto.getReadcount()%></td>
			</tr>
			<tr>
				<th style="background-color: #eeeeee; text-align: center;">작성자</th>
				<td align="center"><%=dto.getWriter()%></td>
				<th style="background-color: #eeeeee; text-align: center;">작성일</th>
				<td align="center"><%=dto.getReg_date()%></td>
			</tr>
			<tr>
				<th style="background-color: #eeeeee; text-align: center;">글제목</th>
				<td colspan="3" align="center"><%=dto.getSubject()%></td>
			</tr>
			<tr>
				<th style="background-color: #eeeeee; text-align: center;">글내용</th>
				<td colspan="3" align="center"><%=dto.getContent()%></td>
			</tr>
<%		if (dto.getFilesize()>0){%>
			<tr>
				<th style="background-color: #eeeeee; text-align: center;">파일명</th>
				<td colspan="3" align="center"><%=dto.getFilename()%></td>
			</tr>			
<%		}%>			
			<tr>
				<td colspan="4" align="right">
						<%
          if(userID != null){
        	  if(userID.equals(Wuser)){
        	  
          
          %>
					<input type="button" value="답글달기" class="btn btn-primary pull-right"
						onclick="window.location='write_form.board?num=<%=dto.getNum()%>&re_step=<%=dto.getRe_step()%>&re_level=<%=dto.getRe_level()%>'">					
					<input type="button" value="글수정" class="btn btn-primary pull-right"onclick="window.location='update_form.board?num=<%=dto.getNum()%>'">
					<input type="button" value="글삭제" class="btn btn-primary pull-right"onclick="window.location='delete_form.board?num=<%=dto.getNum()%>'">
					<input type="button" value="글목록" class="btn btn-primary pull-right"onclick="window.location='list.board'">
				<%}else if(!userID.equals(Wuser)){
					%>
					<input type="button" value="글목록" class="btn btn-primary pull-right"onclick="window.location='list.board'">
					<input type="button" value="답글달기" class="btn btn-primary pull-right"
						onclick="window.location='write_form.board?num=<%=dto.getNum()%>&re_step=<%=dto.getRe_step()%>&re_level=<%=dto.getRe_level()%>'">					
				<% }%>
				
			<% }else{%>
				<input type="button" value="글목록" class="btn btn-primary pull-right"onclick="window.location='list.board'">
			<% }%>
			</td>
			</tr>
		</table>
	</div>
	</div>
</body>
</html>






