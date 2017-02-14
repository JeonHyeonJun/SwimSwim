package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() throws Exception {

		Context ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/product_db");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	//select 후 닫기
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try {
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//inset, update, delete 후 닫기
	public static void close(Connection conn, Statement stmt){
		try {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
