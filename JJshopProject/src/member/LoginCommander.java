package member;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import board.BoardDataBean;
import loginDao.LoginDao;


public class LoginCommander implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		
		String viewpage = null;
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
	
		LoginDao logdao = new LoginDao();
		try {
			System.out.println("받은 아이디값"+id);
			System.out.println("받은비번값"+password);
			String a = logdao.login(id, password);
			System.out.println("a:"+a);
			String msg = null, url = null;
			HttpSession session = req.getSession();
				if (a=="1"){
					session.setAttribute("userID", id);
					msg = "로그인 성공!!메인페이지로 이동합니다";
					url = "index.jsp";
				}else if (a!="1"){
					msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요";
					url = "member/loginForm.jsp";
				}
				req.setAttribute("msg",msg);
				req.setAttribute("url", url);
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}


		return "message.jsp";
			
	}
}