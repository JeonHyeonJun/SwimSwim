package server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import protocol.Account;

public class AccountDao {
	private Connection connection;
	private static String URL = "jdbc:mysql://127.0.0.1/book_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	
	private static AccountDao instance;
	public static AccountDao getInstance()
	{
		
		if(instance == null)
		{
			instance = new AccountDao();
		}
		return instance;
	}
	private AccountDao() {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
	public void close()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void InsertAccount(String ano, String name, int bal)
//	account table�� �ϳ��� ���������� insert �ϱ� ���ؼ� �ʿ��� ������ ���� �������?
//	���¹�ȣ , ������, �ʱ��Աݾ�,	DB��������, Connection, Statement
//	InsertAccount��� insert�Լ��� �����Ҷ��� �ʿ��� ���� �����ϱ��?
//			���¹�ȣ , ������, �ʱ��Աݾ�, Statement
	// 
	{
		String sql = "INSERT INTO account VALUES (?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			System.out.println("insert");
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.setString(2, name);
			pstmt.setInt(3, bal);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally
		{
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public boolean UpdateAccount(String ano, String name, int bal)
	{
		//���¹�ȣ�� �ش��ϴ� ���ڵ��� �����ֿ� �ݾ������� ���� ������ ����
		String sql = "UPDATE account SET owner = ? , balance = ? WHERE ano = ?";
		PreparedStatement pstmt = null;
		try {
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(3, ano);
			pstmt.setString(1, name);
			pstmt.setInt(2, bal);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally
		{
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return true;
	}
	public void DeleteAccount(String ano)
	{
		//���¹�ȣ�� �޾Ƽ� ���¹�ȣ�� �ش��ϴ� ���ڵ带 ����
		String sql = "DELETE FROM account WHERE ano like ?";
		PreparedStatement pstmt = null;
		try {
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally
		{
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public List<Account> SelectAll()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Account> temp = new ArrayList<Account>();
		String sql = "SELECT * FROM account";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Account s = new Account();
				s.setAno(rs.getString(1));
				s.setName(rs.getString(2));
				s.setBal(rs.getInt(3));
				temp.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return temp;
	}
	public int isBeing(String ano)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "SELECT * FROM account";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				if(ano.equals(rs.getString(1)))
				{
					count++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return count;
	}
	public Account SelectOne(String ano)
	{
		Account account = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "SELECT * FROM account";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				if(ano.equals(rs.getString(1)))
				{
					account = new Account();
					account.setName(rs.getString(2));
					account.setAno(rs.getString(1));
					account.setBal(rs.getInt(3));
					
					return account;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return account;
	}
	
}
