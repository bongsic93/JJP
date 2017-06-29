package MemberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jdbc.DBCPConnection;
import jdbc.JdbcUtil;
import memberDto.MemberDto;

public class MemberDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public MemberDao(){
		try{
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:/comp/env/jdbc/oracle");
		}catch(NamingException e){
			System.err.println("오라클 연결 실패!!");
			e.printStackTrace();
		}
	}
	   
	
	
	public void join(String userName, String userID,String userPW ,String userEmail ,String userGender ) throws SQLException{
		String sql = "insert into member values(?,?,?,?,?)";
	   
	     

		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userID);
			pstmt.setString(3, userPW);
			pstmt.setString(4, userEmail);
			pstmt.setString(5, userGender);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}


		
	}
	
	
	public String idCheck(String id) throws SQLException, NamingException{
		
		String result = null;
		  
		   
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("select userID from member where userID = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()){
				String id2 = rs.getString("userID");
				System.out.println("중복!db에 있는 값"+id2);
				if(id.equals(id2)){
					result = "2";
				}

			}else if(id == null){
				result = "0";
			}else{

				System.out.println("중복 아이디 없음.");
				result = "1";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		return result;

	}
	
	
	public String idSelect(String id) throws SQLException, NamingException{
	
		;
		String result = null;

		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("select userID from member where userID = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getString("userID");
				System.out.println("로그인 할 아이디 :"+id);
			}else{
				System.out.println("아이디 없음");


			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		return result;

	}

	public String passwordSelect(String id) throws SQLException, NamingException{
		 
		String result = null;

		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("select userPW from member where userID = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getString("userPW");
				System.out.println("로그인 할 비밀번호:"+result);
			}else{
				System.out.println("비번 없음");

			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		return result;

	}
	
	
	public String IdSearch(String name, String Email ){
		String id = null;
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("select userID from member where userName = ? and userEmail = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, Email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				id = "찾은 아이디 :" + rs.getString("userID");
				System.out.println("찾은 아이디:" + id);
			}else{
				System.out.println("아이디 찾기 실패" + id);
				id = "정보에 맞는 아이디가 존재하지 않습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		return id;
		
	}
	
	public String PwSearch(String name, String Email, String id){
		String pw = null;
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("select userPW from member where userName = ? and userEmail = ? and userID =?");
			pstmt.setString(1, name);
			pstmt.setString(2, Email);
			pstmt.setString(3, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()){
				pw = "찾은 비밀번호 :" + rs.getString("userPW");
				System.out.println("찾은 비밀번호:" + pw);
			}else{
				System.out.println("비밀번호 찾기 실패" + pw);
				pw = "정보에 맞는 비밀번호가 존재하지 않습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		return pw;
		
	}

	
	
	public String getPW(String uid){
		String pw = null;
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("select userPW from member where userID = ?");
			pstmt.setString(1, uid);
		
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				pw = rs.getString("userPW");
				System.out.println("찾은 비밀번호:" + pw);
			}else{
				System.out.println("비밀번호 찾기 실패" + pw);
				pw = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		return pw;
		
	}
	
	public MemberDto memberInfo(String uid){
		MemberDto dto = new MemberDto();
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("select * from member where userID = ?");
			pstmt.setString(1, uid);
		
			rs = pstmt.executeQuery();
			
			if(rs.next()){
			String name = rs.getString("userName");
			String id = rs.getString("userID");
			String Email = rs.getString("userEmail");
			String password = rs.getString("userPW");
			String gender = rs.getString("userGender");
			
			dto.setUserID(id);
			dto.setUserName(name);
			dto.setUserEmail(Email);
			dto.setUserPW(password);
			dto.setUserGender(gender);
			
			return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		return dto;
		
	}
	
	public void memInfoModify(String id, String password, String Email ){
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("update member set userPW = ? ,userEmail = ? where userID = ? ");
			pstmt.setString(1, password );
			pstmt.setString(2, Email );
			pstmt.setString(3, id );
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		
		
		
	}
	
	
}
