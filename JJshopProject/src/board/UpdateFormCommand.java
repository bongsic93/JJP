package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		BoardDataBean dao = new BoardDataBean();
		BoardDBBean dto = dao.getBoard(Integer.parseInt(num));
		req.setAttribute("getBoard", dto);
		return "board/updateForm.jsp";
	}

}
