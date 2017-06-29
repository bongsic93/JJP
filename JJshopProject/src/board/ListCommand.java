package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		BoardDataBean dao = new BoardDataBean();
		List<BoardDBBean> list = dao.listBoard();
		req.setAttribute("boardList", list);
		return "board/list.jsp";
	}

}
