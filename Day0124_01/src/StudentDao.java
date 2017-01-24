import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	private static Connection connection;
	private static String URL = "jdbc:mysql://127.0.0.1/student_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	private static StudentDao instance;

	public static StudentDao getInstance() {
		if (instance == null)
			instance = new StudentDao();
		return instance;
	}

	private StudentDao() {
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

	public void insert(String name, int age, int score) {
		String sql = "insert into student values(0,?,?,?)";
		PreparedStatement prt = null;
		try {
			prt = connection.prepareStatement(sql);
			prt.setString(1, name);
			prt.setInt(2, age);
			prt.setInt(3, score);
			prt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(int s_id, String name, int age, int score) {
		String sql = "update student set name=?, age=?, score=? where s_id=?";
		PreparedStatement prt = null;
		
		try {
			prt = connection.prepareStatement(sql);
			prt.setString(1, name);
			prt.setInt(2, age);
			prt.setInt(3, score);
			prt.setInt(4, s_id);
			prt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int s_id) {
		String sql = "delete from student where s_id=?";
		PreparedStatement prt = null;
		
		try {
			prt = connection.prepareStatement(sql);
			prt.setInt(1, s_id);
			prt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
