package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		BoardDBBean dto = new BoardDBBean();
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setContent(req.getParameter("content"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		BoardDataBean dao = new BoardDataBean();
		int res = dao.updateBoard(dto);
		String msg = null, url = null;
		if (res>0){
			msg = "게시글 수정 성공!! 글목록페이지로 이동합니다.";
			url = "list.board";
		}else if (res<0){
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요";
			url = "update_form.board?num="+dto.getNum();
		}else {
			msg = "게시글 수정 실패!! 글상세보기페이지로 이동합니다.";
			url = "content.board?num="+dto.getNum();
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}
}
