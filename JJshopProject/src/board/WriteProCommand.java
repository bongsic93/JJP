package board;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

public class WriteProCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		
		MultipartRequest mr = null;
		HttpSession session = req.getSession();
		String upPath = session.getServletContext().getRealPath("board/files");
		int len = 10*1024*1024;
		try{
			req.setCharacterEncoding("utf-8");
			mr = new MultipartRequest(req, upPath, len, "utf-8");
			//mr��ü�� ���������, ���Ͼ��ε� ����!!, ��ü ���н� IOException �߻�!!
		}catch(IOException e){
			System.err.println("���� ���ε� �� ����!!");
		}
		BoardDBBean dto = new BoardDBBean();
		dto.setNum(Integer.parseInt(mr.getParameter("num")));
		dto.setRe_step(Integer.parseInt(mr.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(mr.getParameter("re_level")));
		dto.setWriter(mr.getParameter("writer"));
		dto.setEmail(mr.getParameter("email"));
		dto.setSubject(mr.getParameter("subject"));
		dto.setContent(mr.getParameter("content"));
		dto.setPasswd(mr.getParameter("passwd"));
		dto.setIp(req.getRemoteAddr());
		dto.setFilename(mr.getFilesystemName("filename"));
		int filesize = 0;
		File file = mr.getFile("filename");
		if (file != null){
			filesize = (int)file.length();
		}
		dto.setFilesize(filesize);
		BoardDataBean dao = new BoardDataBean();
		int res = dao.insertBoard(dto);
		String msg = null, url = null;
		if (res>0){
			msg = "�Խñ� ��� ����!! �۸���������� �̵��մϴ�";
			url = "list.board";
		}else {
			msg = "�Խñ� ��� ����!! �۵���������� �̵��մϴ�.";
			url = "write_form.board";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}










