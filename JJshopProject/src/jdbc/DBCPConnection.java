package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCPConnection {
		public static Connection getConnection(){
			Context init;
			Connection conn = null;
			try {
				init = new InitialContext();
				DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
				 try {
					conn = ds.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			return conn;
		}
	}