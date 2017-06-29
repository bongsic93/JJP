import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppFrontController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=EUC-KR");
		req.setCharacterEncoding("EUC-KR");

		String uri=req.getRequestURI();//(��ü���)���� �ּҰ� �޾ƿ���
		String path=req.getContextPath();//���۰��
		String cmd=uri.substring(path.length());//���ϰ��� �ϴ� �̸� = uri-path
		String nextPage=null;

		if(cmd.equals("/member.app")){
			nextPage="member_index.member";		//servlet �������� �̵�
		}else if(cmd.equals("/login.app")){
			nextPage="login.jsp";				//���� �������̵�

		}else if(cmd.equals("/board.app")){
			nextPage="list.board";				//servlet �������� �̵�

		}else if(cmd.equals("/shop.app")){
			nextPage="mall.shop";				//servlet �������� �̵�

		}
		RequestDispatcher view =req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}

}
