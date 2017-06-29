package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();			//전체경로
		String path = req.getContextPath();		//시작경로
		String cmd = uri.substring(path.length()); //구하고자 하는 이름
		
		MemberFactory factory = MemberFactory.getInstance();
		CommandIf cmdIf = factory.createCommand(cmd);
		String nextPage = (String)cmdIf.processCommand(req, resp);
		
		System.out.println("factory : "+factory);
		System.out.println("cmdIf : "+cmdIf);
		System.out.println("nextPage : "+nextPage);

		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}

	
}
