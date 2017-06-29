package board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

public class BoardDataBean {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private DataSource ds;
	
	public BoardDataBean(){
		try{
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:/comp/env/jdbc/oracle");
		}catch(NamingException e){
			System.err.println("오라클 연결 실패!!");
			e.printStackTrace();
		}
	}
	
	public List<BoardDBBean> listBoard(){
		String sql = "select * from board order by re_step asc";
		List<BoardDBBean> list = null;
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			list = makeList(rs);
		}catch(SQLException e){
			System.err.println("listBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally{
			try{
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e){}
		}
		return list;
	}
	
	protected List<BoardDBBean> makeList(ResultSet rs) throws SQLException{
		List<BoardDBBean> list = new ArrayList<BoardDBBean>();
		while(rs.next()){
			BoardDBBean dto = new BoardDBBean();
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			dto.setRe_step(rs.getInt("re_step"));
			dto.setRe_level(rs.getInt("re_level"));
			dto.setFilename(rs.getString("filename"));
			dto.setFilesize(rs.getInt("filesize"));
			list.add(dto);
		}
		return list;
	}
	
	public int insertBoard(BoardDBBean dto) {
		String sql = null;
		if (dto.getNum()==0){	//새글이냐?
			sql = "update board set re_step = re_step + 1";
		}else {						//답글이냐?
			sql = "update board set re_step = re_step + 1 where re_step > " + dto.getRe_step();
			dto.setRe_step(dto.getRe_step() + 1);
			dto.setRe_level(dto.getRe_level() + 1);
		}
		int res = 0;
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			
			sql = "insert into board values(board_num.nextval, ?,?,?,?,sysdate,0,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getPasswd());
			ps.setString(5, dto.getContent());
			ps.setString(6, dto.getIp());
			ps.setInt(7, dto.getRe_step());
			ps.setInt(8, dto.getRe_level());
			ps.setString(9, dto.getFilename());
			ps.setInt(10, dto.getFilesize());
			res = ps.executeUpdate();
		}catch(SQLException e){
			System.err.println("insertBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally{
			try{
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e){}
		}
		return res;
	}
	
	public void plusReadCount(int num){
		String sql = "update board set readcount = readcount + 1 where num = ?";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		}catch(SQLException e){
			System.err.println("plusReadCount 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally{
			try{
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e){}
		}
	}
	
	public BoardDBBean getBoard(int num){
		String sql = "select * from board where num = ?";
		BoardDBBean dto = null;
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			List<BoardDBBean> list = makeList(rs);
			dto = list.get(0);
		}catch(SQLException e){
			System.err.println("getBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally{
			try{
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e){}
		}
		return dto;
	}
	
	public int deleteBoard(int num, String passwd){
		try{
			if (isPassword(num, passwd)){
				String sql = "delete from board where num = ?";
				con = ps.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				return ps.executeUpdate();//삭제된 갯수를 리턴한다
			}
		}catch(SQLException e){
			System.err.println("deleteBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally{
			try{
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e){}
		}
		return -1;
	}
	
	protected boolean isPassword(int num, String passwd) throws SQLException {
		String sql = "select passwd from board where num = ?";
		con = ds.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		rs = ps.executeQuery();
		rs.next();
		String dbPass = rs.getString(1);
		if (dbPass.equals(passwd)){
			return true;
		}
		return false;
	}
	
	public int updateBoard(BoardDBBean dto) {
		try{
			if (isPassword(dto.getNum(), dto.getPasswd())){
				String sql = "update board set writer=?, email=?, subject=?,content=? where num=?"; 
				con = ds.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getWriter());
				ps.setString(2, dto.getEmail());
				ps.setString(3, dto.getSubject());
				ps.setString(4, dto.getContent());
				ps.setInt(5, dto.getNum());
				return ps.executeUpdate();
			}
		}catch(SQLException e){
			System.err.println("updateBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally{
			try{
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e){}
		}
		return -1;
	}
}












