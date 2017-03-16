package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDao {	
	private static Connection connection;
	private static String URL = "jdbc:mysql://127.0.0.1/custom_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	
	private static CustomerDao instance;

	public static CustomerDao getInstance() {
		if(instance == null)
			instance = new CustomerDao();
		return instance;
	}
	
	private CustomerDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			System.out.println("SQLException");
		}
	}
	
	public boolean insertCustomer(Customer c) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO customer VALUES (0,?,?,?,?,?)";

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getName());
			pstmt.setInt(3, c.getAge());
			pstmt.setString(4, c.getTel());
			pstmt.setString(5, c.getAddr());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteCustomer(String id) {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM customer WHERE id = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void updatecustomer(Customer customer) {
		String sql = "update customer set name=?, age=?, tel=?, addr=? where id=?";
		PreparedStatement pstmt  = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setInt(2, customer.getAge());
			pstmt.setString(3, customer.getTel());
			pstmt.setString(4, customer.getAddr());
			pstmt.setString(5, customer.getId());
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
	
	
	
	public Customer selectOne(String id){
		String sql = "select * from customer where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer customer = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				customer = new Customer();
				customer.setNo(rs.getInt("no"));
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setAge(Integer.parseInt(rs.getString("age")));
				customer.setTel(rs.getString("tel"));
				customer.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt !=null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return customer;
	}

	
	public List<Customer> selectAll() {
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select * from customer";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setNo(rs.getInt("no"));
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setAge(Integer.parseInt(rs.getString("age")));
				customer.setTel(rs.getString("tel"));
				customer.setAddr(rs.getString("addr"));
				list.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt !=null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return list;
	}
}
