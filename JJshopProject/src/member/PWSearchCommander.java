package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDao.MemberDao;

public class PWSearchCommander implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String viewpage = null;
		String searchRS = null;
		try {
			String id = req.getParameter("id");
			String Email = req.getParameter("Email");
			String name = req.getParameter("name");
			MemberDao dao = new MemberDao();
			searchRS = dao.PwSearch(name, Email,id);
			req.setAttribute("searchPW", searchRS);
			viewpage = "member/searchPwFormRS.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return viewpage;
	}
}
