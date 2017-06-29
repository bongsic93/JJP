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

		String uri=req.getRequestURI();//(전체경로)현재 주소값 받아오기
		String path=req.getContextPath();//시작경로
		String cmd=uri.substring(path.length());//구하고자 하는 이름 = uri-path
		String nextPage=null;

		if(cmd.equals("/member.app")){
			nextPage="member_index.member";		//servlet 페이지로 이동
		}else if(cmd.equals("/login.app")){
			nextPage="login.jsp";				//실제 페이지이동

		}else if(cmd.equals("/board.app")){
			nextPage="list.board";				//servlet 페이지로 이동

		}else if(cmd.equals("/shop.app")){
			nextPage="mall.shop";				//servlet 페이지로 이동

		}
		RequestDispatcher view =req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}

}
