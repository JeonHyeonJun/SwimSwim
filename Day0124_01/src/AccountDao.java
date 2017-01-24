import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
	private static Connection connection;

	private static String URL = "jdbc:mysql://127.0.0.1/book_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	private static AccountDao instance;

	public static AccountDao getInstance() {
		if (instance == null)
			instance = new AccountDao();
		return instance;
	}

	private AccountDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클라스 적재 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB연결 실패");
		}
	}

	public Account selectOne(String ano) {
		Account account = null;
		PreparedStatement prt = null;
		ResultSet rs = null;
		String sql = "select * from account where ano=?";

		try {
			prt = connection.prepareStatement(sql);
			prt.setString(1, ano);
			rs = prt.executeQuery();

			if (rs.next()) {
				account = new Account();
				account.setAno(rs.getInt("ano"));
				account.setOwner(rs.getString("owner"));
				account.setBalance(rs.getInt("balance"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return account;
	}

	public List<Account> selectAll() {
		List<Account> list = new ArrayList<Account>();
		PreparedStatement prt = null;
		ResultSet rs = null;
		String sql = "select * from account";

		try {
			prt = connection.prepareStatement(sql);
			rs = prt.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAno(rs.getInt("ano"));
				account.setOwner(rs.getString("owner"));
				account.setBalance(rs.getInt("balance"));
				list.add(account);
				System.out.println(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return list;
	}

	public void insert(String ano, String owner, int balance) {
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

	public void update(String ano, String owner, int balance) {
		// 계좌번호, 계좌주, 금액을 입력받아서 계좌번호에 해닫하는 레코드의 계좌주와 금액정보를 받은값으로 수정
		String sql = "update account set owner=?,balance=? where ano=?";
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
		}
	}

	public void delete(String ano) {
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
