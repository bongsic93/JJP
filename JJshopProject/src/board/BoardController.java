package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
														throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=EUC-KR");
		req.setCharacterEncoding("EUC-KR");
		
		String uri = req.getRequestURI();			//전체경로
		String path = req.getContextPath();		//시작경로
		String cmd = uri.substring(path.length()); //구하고자 하는 이름
		
		BoardFactory factory = BoardFactory.getInstance();
		CommandIf cmdIf = factory.createCommand(cmd);
		String nextPage = (String)cmdIf.processCommand(req, resp);
		
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
	
}













