package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import protocol.Professor;
import protocol.Student;
import protocol.Student_Subject;
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

	// 학생로그인
	public Student st_login(String id, String ps) {
		String sql = "select * from student where id=? and password=?";
		Student st = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, ps);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (id.equals(rs.getString("id")) && ps.equals(rs.getString("password"))) {
					st = new Student();
					st.setStnumber(rs.getString(1));
					st.setName(rs.getString(2));
					st.setId(rs.getString(3));
					st.setPassword(rs.getString(4));
					return st;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return st;
	}

	// 교수로그인
	public Professor pr_login(String id, String ps) {
		String sql = "select * from professor where id=? and password=?";
		Professor pr = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, ps);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (id.equals(rs.getString("id")) && ps.equals(rs.getString("password"))) {
					pr = new Professor();
					pr.setPrnumber(rs.getString(1));
					pr.setName(rs.getString(2));
					pr.setId(rs.getString(3));
					pr.setPassword(rs.getString(4));
					return pr;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pr;
	}

	// 교수과목출력
	public List<Subject> pr_subjectlist(String prnum) {
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

	// 학생과목출력
	public List<Subject> st_subjectlist(String stnum) {
		String sql = "select * from st_subject where stnumber=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// ResultSet rs2 = null;
		List<Subject> list = new ArrayList<Subject>();
		List<Student_Subject> stsub = new ArrayList<Student_Subject>();

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, stnum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (stnum.equals(rs.getString(1))) {
					Student_Subject ss = new Student_Subject();
					ss.setSubnumber(rs.getString(2));
					stsub.add(ss);
				}
			}

			String sql2 = "select * from subject where subnumber=?";
			pstmt = connection.prepareStatement(sql2);
			for (int i = 0; i < stsub.size(); i++) {
				pstmt.setString(1, stsub.get(i).getSubnumber());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					Subject s = new Subject();
					s.setSubnumber(rs.getString(1));
					s.setSubname(rs.getString(2));
					s.setPrnumber(rs.getString(3));
					s.setSubAttendnumber(rs.getInt(4));
					list.add(s);
				}
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

	// 강의선택
	public Subject subjectselect(String subnumber) {
		String sql = "select * from subject where subnumber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Subject sub = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, subnumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (subnumber.equals(rs.getString(1))) {
					sub = new Subject();
					sub.setSubnumber(rs.getString(1));
					sub.setSubname(rs.getString(2));
					sub.setPrnumber(rs.getString(3));
					sub.setSubAttendnumber(rs.getInt(4));
					return sub;
				}
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
		return sub;
	}
	
	//출석번호확인
	public Subject attendnumberOk(String subnumber, int attnumber){
		String sql = "select * from subject where subnumber=? and subAttendnumber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Subject sub = new Subject();

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, subnumber);
			pstmt.setInt(2, attnumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (attnumber == rs.getInt(4)) {
					sub.setSubAttendnumber(rs.getInt(4));
					return sub;
				}
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
		return sub;
	}

	// 출석번호출력
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
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 출석률출력
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
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Student_Subject student_subject(String stnumber, String subnumber) {
		String sql = "select * from st_subject where stnumber=? and subnumber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student_Subject sub = new Student_Subject();

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, stnumber);
			pstmt.setString(2, subnumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (subnumber.equals(rs.getString(2))) {
					sub.setAttendnumber(rs.getInt(3));
					return sub;
				}
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
		return sub;
	}

}
