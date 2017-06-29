package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberDao.MemberDao;
import memberDto.MemberDto;

public class MypageInfoForm implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		String viewpage = null;
		
		try {
			HttpSession session = req.getSession();
			
			
			String id = (String) session.getAttribute("userID");
			
			
			MemberDao dao = new MemberDao();
			
			MemberDto dto = dao.memberInfo(id);
			
			
				req.setAttribute("memInfo", dto);
				viewpage = "member/mypageInfoForm.jsp";
		
				
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return viewpage;
	}

}
