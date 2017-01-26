package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import protocol.Subject;

public class AttendDao {
	private Connection connection;
	private static String URL = "jdbc:mysql://127.0.0.1/attendance_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	private static AttendDao instance;

	public static AttendDao getInstance() {
		if (instance == null)
			instance = new AttendDao();
		return instance;
	}

	private AttendDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//출석번호출력
	public void updateAttendNumber(int attsubnum, String subnum) {
		String sql = "update subject set subAttendnumber=? where subnumber=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, attsubnum);
			pstmt.setString(2, subnum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//출석률출력
	public void updateStudentAttend(int attnum, String stnum, String subnum) {
		String sql = "update st_subject set attendnumber=? where stnumber=? and subnumber=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, attnum);
			pstmt.setString(2, stnum);
			pstmt.setString(3, subnum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//교수과목출력
	public List<Subject> selectProSub(String prnum) {
		String sql = "select * from subject where prnumber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Subject> list = new ArrayList<Subject>();

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, prnum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Subject s = new Subject();
				s.setSubnumber(rs.getString(1));
				s.setSubname(rs.getString(2));
				s.setPrnumber(rs.getString(3));
				s.setSubAttendnumber(rs.getInt(4));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	//학생과목출력
	public List<Subject> selectStuSub(String stnum){
		String sql = "select subnumber from st_subject where stnumber=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Subject> list = new ArrayList<Subject>();
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, stnum);
			rs = pstmt.executeQuery();
			String sql2 = "select * from subject where subnumber="+rs.getString(1);
			pstmt = connection.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Subject s = new Subject();
				s.setSubnumber(rs.getString(1));
				s.setSubname(rs.getString(2));
				s.setPrnumber(rs.getString(3));
				s.setSubAttendnumber(rs.getInt(4));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
