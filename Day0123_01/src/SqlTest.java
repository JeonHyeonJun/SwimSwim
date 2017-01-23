import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SqlTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection connetion = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connetion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/book_db", "root", "mysql");
			
			System.out.print("니이름: ");
			String name = scan.nextLine();
			System.out.print("니나이: ");
			int age = scan.nextInt();
			System.out.print("데스노트입니다.이름을 적어주세요 ");
			String deathnote = scan.next();
			System.out.print("되고싶은 나이를 입력해주세요 ");
			int agechange = scan.nextInt();
			System.out.print("나이가 바뀌는 사람의 이름을 입력해주세요 ");
			String namechange = scan.next();
			
			String sql = "insert into human values(?,?)";
			String sq1 = "delete from human where name like ?";
			String sqI = "update human set age=? where name like ?";
			
			PreparedStatement prtmt = connetion.prepareStatement(sql);
//			PreparedStatement prtmt2 = connetion.prepareStatement(sq1);
//			PreparedStatement prtmt3 = connetion.prepareStatement(sqI);
			
			prtmt.setString(1, name);
			prtmt.setInt(2, age);
			prtmt.executeUpdate();
			
			prtmt = connetion.prepareStatement(sq1);
			prtmt.setString(1, deathnote);
			prtmt.executeUpdate();

			prtmt = connetion.prepareStatement(sqI);
			prtmt.setInt(1, agechange);
			prtmt.setString(2, namechange);
			prtmt.executeUpdate();

			
//			prtmt2.executeUpdate();
//			prtmt3.executeUpdate();
			
			prtmt.close();
//			prtmt2.close();
//			prtmt3.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try{
				if(connetion != null)
					connetion.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
