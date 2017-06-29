<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, board.*" %>    
<!-- list.jsp -->
<html>
	<head>
		<title>mvc게시판</title>
	</head>
	<body>
		<div align="center">
			<b>글 목 록</b>
			<table border="0" width="800">
				<tr bgcolor="yellow">
					<td align="right"><a href="write_form.board">글쓰기</a></td>
				</tr>
			</table>
			<table border="1" width="800">
				<tr bgcolor="green">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회</th>
					<th>IP</th>
				</tr>
<%			List<BoardDBBean>boardList = (List)request.getAttribute("boardList"); 
				if (boardList == null || boardList.size() == 0){%>
				<tr>
					<td colspan="6">
						게시된 글이 없습니다.
					</td>
				</tr>								
<%			}else { 
					for(BoardDBBean dto : boardList){%>
				<tr>
					<td><%=dto.getNum()%></td>
					<td><a href="content.board?num=<%=dto.getNum()%>"><%=dto.getSubject()%></a></td>
					<td><%=dto.getWriter()%></td>
					<td><%=dto.getReg_date()%></td>
					<td><%=dto.getReadcount()%></td>
					<td><%=dto.getIp()%></td>
				</tr>	
<%				}
				} %>				
			</table>
		</div>
	</body>
</html>
