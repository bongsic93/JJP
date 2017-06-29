package board;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		BoardDataBean dao = new BoardDataBean();
		
		Cookie cks[] = req.getCookies();
		boolean isCheck = false;
		for(int i=0; i<cks.length; ++i){
			String name = cks[i].getName();
			if (name.equals("check")){
				String value = cks[i].getValue();
				if (value.trim().equals(num)){
					isCheck = true;
				}
			}
		}
		if (!isCheck) dao.plusReadCount(Integer.parseInt(num));
		Cookie ck = new Cookie("check", num);
		ck.setMaxAge(7*24*60*60);
		resp.addCookie(ck);//F5눌러도 조회수는 올라가지않는다.
		
		BoardDBBean dto = dao.getBoard(Integer.parseInt(num));
		req.setAttribute("getBoard", dto);
		return "board/content.jsp";
	}

}
