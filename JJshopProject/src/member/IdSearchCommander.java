package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDao.MemberDao;

public class IdSearchCommander implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String viewpage = null;
		String searchRS = null;
		try {
			String Email = req.getParameter("Email");
			String name = req.getParameter("name");
			MemberDao dao = new MemberDao();
			searchRS = dao.IdSearch(name, Email);
			req.setAttribute("searchRS", searchRS);
			viewpage = "member/searchIdFormRS.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return viewpage;
	}

}
