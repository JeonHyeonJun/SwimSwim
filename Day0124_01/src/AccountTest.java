import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountTest {
	private static Connection connection;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/book_db", "root", "mysql");
			boolean run = true;

//			insert("1","2",3);
//			update("111","zz",777);
			while (run) {
				System.out.println("============================");
				System.out.println("1.계좌추가 2.계좌수정 3.계좌삭제 4.종료");
				System.out.println("============================");
				System.out.print("선택> ");
				int select = scan.nextInt();

				if (select == 1) {
					System.out.print("계좌번호 ");
					String ano = scan.next();
					System.out.print("계좌주 ");
					String owner = scan.next();
					System.out.print("금액 ");
					int balance = scan.nextInt();
					insert(ano, owner, balance);
				} else if (select == 2) {
					System.out.print("계좌주 ");
					String owner = scan.next();
					System.out.print("금액 ");
					int balance = scan.nextInt();
					System.out.print("계좌번호 ");
					String ano = scan.next();
					update(ano, owner, balance);
				} else if (select == 3) {
					System.out.print("계좌번호 ");
					String ano = scan.next();
					delete(ano);
				} else if (select == 4) {
					System.out.println("종료합니다");
					run = false;
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클라스 적재 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB연결 실패");
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

	public static void insert(String ano, String owner, int balance) {
		String sql = "insert into account values(?,?,?)";
		PreparedStatement prtmt = null;

		try {
			prtmt = connection.prepareStatement(sql);
			prtmt.setString(1, ano);
			prtmt.setString(2, owner);
			prtmt.setInt(3, balance);
			prtmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (prtmt != null)
					prtmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void update(String ano, String owner, int balance) {
		// 계좌번호, 계좌주, 금액을 입력받아서 계좌번호에 해닫하는 레코드의 계좌주와 금액정보를 받은값으로 수정
		String sql = "update account set owner=?,banlance=? where ano=?";
		PreparedStatement prtmt = null;

		try {
			prtmt = connection.prepareStatement(sql);

			prtmt.setString(1, owner);

			prtmt.setInt(2, balance);

			prtmt.setString(3, ano);
			prtmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (prtmt != null)
					prtmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void delete(String ano) {
		// 계좌번호를 받아서 계좌번호에 해당하는 레코드를 삭제
		String sql = "delete from account where ano=?";
		PreparedStatement prtmt = null;

		try {
			prtmt = connection.prepareStatement(sql);
			prtmt.setString(1, ano);
			prtmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (prtmt != null)
					prtmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
