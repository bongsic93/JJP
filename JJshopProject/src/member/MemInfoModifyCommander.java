package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDao.MemberDao;


public class MemInfoModifyCommander implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String viewpage = null;
		try {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String Email = req.getParameter("Email");
			String gender = req.getParameter("gender");
			String name = req.getParameter("name");
			
			MemberDao dao = new MemberDao();
			dao.memInfoModify(id, password, Email);
			
			viewpage = "member/memInfoModifySuccess.jsp";

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return viewpage;
	}

}
