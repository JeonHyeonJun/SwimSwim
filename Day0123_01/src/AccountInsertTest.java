import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountInsertTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection connetion = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connetion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/book_db", "root", "mysql");
			
			System.out.print("계좌번호: ");
			String ano = scan.nextLine();
			System.out.print("계좌주: ");
			String owner = scan.nextLine();
			System.out.print("입금액: ");
			int balance = scan.nextInt();
			
			String sql = "insert into account values(?,?,?)";
			
			PreparedStatement pstmt = connetion.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.setString(2, owner);
			pstmt.setInt(3, balance);
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(result+"개의 행 추가완료");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(connetion != null)
					connetion.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
