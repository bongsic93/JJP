package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDao.MemberDao;
import memberDto.MemberDto;

public class mypageCheckCommander implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		
		String viewpage = null;
		String Inpw = null;
		try {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			MemberDao dao = new MemberDao();
			Inpw = dao.getPW(id);
			MemberDto dto = dao.memberInfo(id);
			
			if(Inpw.equals(password)){
				req.setAttribute("memInfo", dto);
				viewpage = "member/mypageForm.jsp";
			}else if(!Inpw.equals(password)){
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('비밀번호 불일치'); history.go(-1);</script>");
				out.flush();
				
			}
			
			System.out.println(id+" and " + password+" and "+Inpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return viewpage;
	}

}
