package loginDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import MemberDao.MemberDao;
import jdbc.DBCPConnection;
import jdbc.JdbcUtil;
import loginDto.LoginDto;


public class LoginDao {

public LoginDao() {
	
}
	
	public String login(String id, String password) throws SQLException, NamingException {
		
		Connection conn = DBCPConnection.getConnection();
		PreparedStatement pstmt = null;

		
		LoginDto dto = new LoginDto(id,password);
		MemberDao medao = new MemberDao();
		
		String id1 = dto.getId();
		String pw = dto.getPassword();
		String dbid = medao.idSelect(id1);
		String dbpw = medao.passwordSelect(dbid);
		String result = null;
		
		try {
			
			if(pw.equals(dbpw)){
				result = "1";
			}else if(!pw.equals(dbpw)){
				result = "0";

			}
		} catch (Exception e) {

		e.printStackTrace();
		
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

					}
		System.out.println("id1:"+id1);
		System.out.println("pw:"+pw);
		System.out.println("dbid:"+dbid);
		System.out.println("dbpw:"+dbpw);

		System.out.println("로그인할때 비밀번호 일치 확인:"+result);
		return result;
		
	}
	
	
	
}
