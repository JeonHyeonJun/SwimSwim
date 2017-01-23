import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection connection = null;

		try {
			// 드라이버 적재
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 및 커넥션 객체 획득
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/book_db", "root", "mysql");
			
			System.out.print("제목: ");
			String name = scan.nextLine();
			System.out.print("출판사: ");
			String company = scan.nextLine();
			System.out.print("출판연도: ");
			String year = scan.nextLine();
			System.out.print("가격: ");
			int money = scan.nextInt();
			
			//사용할 SQL문을 Statement구문 객체로 준비
//			String sql = "insert into books values(0,'"+name+"','"+company+"','"+year+"',"+money+")";
			String sql = "insert into books values(0,?,?,?,?)";	//PreparedStatement사용법 1.sql문에서 채울 공간을 ?로 채워논다
//			Statement stmt = connection.createStatement();
			PreparedStatement pstmt = connection.prepareStatement(sql);	//2.미완성 sql문장을 매개로 PreparedStatement갹채룰 획득
			pstmt.setString(1, name);
			pstmt.setString(2, company);
			pstmt.setString(3, year);
			pstmt.setInt(4, money);
			
			
			//준비된 구문객체 사용
			int result = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(result + "개의 행이 영향을 받았음");
			
		} catch (ClassNotFoundException e) {
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
}
