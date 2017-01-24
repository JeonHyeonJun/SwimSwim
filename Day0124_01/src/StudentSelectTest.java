import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentSelectTest {
	private static Connection connection;
	private static String URL = "jdbc:mysql://127.0.0.1/student_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	private static Student student;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			System.out.println(selectOne(6));
			System.out.println(selectAll());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static Student selectOne(int s_id) {
		
		String sql = "select * from student where s_id = ?";
		PreparedStatement prt = null;
		ResultSet rs = null;
		try {
			prt = connection.prepareStatement(sql);
			prt.setInt(1, s_id);
			rs = prt.executeQuery();

			if (rs.next()) {
				// 순서로 지정해줘도 되고
				// int s_id = rs.getInt(1);
				// String name = rs.getString(2);
				// int age = rs.getInt(3);
				// int score = rs.getInt(4);

				// 컬럼명으로 지정해줘도 된다
				// int s_id = rs.getInt("s_id");
				// String name = rs.getString("name");
				// int age = rs.getInt("age");
				// int score = rs.getInt("score");

				// System.out.println(s_id+ " " +name+ " " +age+ " " +score);

				student = new Student();
				student.setS_id(rs.getInt("s_id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setScore(rs.getInt("score"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prt != null)
					prt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student;
	}
	
	public static List<Student> selectAll(){
		List<Student> list = new ArrayList<Student>();
		PreparedStatement prt = null;
		ResultSet rs = null;
		String sql = "select * from student";
		
		try{
			prt = connection.prepareStatement(sql);
			rs = prt.executeQuery();
			while( rs.next() ){
				student = new Student();
				student.setS_id(rs.getInt("s_id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setScore(rs.getInt("score"));
				list.add(student);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try{
				if(prt != null)
					prt.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
}
