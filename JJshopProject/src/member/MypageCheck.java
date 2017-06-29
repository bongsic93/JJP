package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MypageCheck implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String loginedID = null;
		loginedID = req.getParameter("id");
		System.out.println("로그인 아이디 " +loginedID);
		
		return "member/mypageCheckForm.jsp?id="+ loginedID;
	}

}
