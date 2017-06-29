package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		String passwd = req.getParameter("passwd");
		
		BoardDataBean dao = new BoardDataBean();
		int res = dao.deleteBoard(Integer.parseInt(num), passwd);
		String msg = null, url = null;
		if (res>0){
			msg = "게시글 삭제 성공!! 글목록페이지로 이동합니다.";
			url = "list.board";
		}else if (res<0){
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요";
			url = "delete_form.board?num="+num;
		}else {
			msg = "게시글 삭제 실패!! 글상세보기페이지로 이동합니다.";
			url = "content.board?num="+num;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}










