import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppFrontController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
													throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=EUC-KR");
		req.setCharacterEncoding("EUC-KR");
		
		String uri = req.getRequestURI();			//��ü���
		String path = req.getContextPath();		//���۰��
		String cmd = uri.substring(path.length()); //���ϰ��� �ϴ� �̸�
		String nextPage = null;
		
		if (cmd.equals("/member.app")){
			nextPage = "member_index.member";	//servlet�������� �̵�
		}else if (cmd.equals("/loginForm.app")){
			nextPage = "loginForm.member";							//������������ �̵�
		}else if (cmd.equals("/board.app")){
			nextPage = "list.board";						//servlet�������� �̵�
		}else if (cmd.equals("/shop.app")){
			nextPage = "mall.shop";						//servlet�������� �̵�
		}else if (cmd.equals("/join.app")){
			nextPage = "join.member";						//servlet�������� �̵�
		}else if (cmd.equals("/joinForm.app")){
			nextPage = "joinForm.member";						//servlet�������� �̵�
		}else if (cmd.equals("/logoutAction.app")){
			nextPage = "logout.member";						//servlet�������� �̵�
		}else if (cmd.equals("/login.app")){
			nextPage = "login.member";						//servlet�������� �̵�
		}else if (cmd.equals("/loginsuccess.app")){
			nextPage = "loginsuccess.member";						//servlet�������� �̵�
		}
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
	
}











