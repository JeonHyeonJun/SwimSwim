import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {
	private static String URL = "jdbc:mysql://127.0.0.1/book_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	private static Connection connection;
	private static BooksDao instance;

	public static BooksDao getInstance() {
		if (instance == null)
			instance = new BooksDao();
		return instance;
	}

	private BooksDao() {
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

	public Book selectOne(String title) {
		Book book = null;
		PreparedStatement prt = null;
		ResultSet rs = null;
		String sql = "select * from books where title like ?";

		try {
			prt = connection.prepareStatement(sql);
			prt.setString(1, title);
			rs = prt.executeQuery();

			if (rs.next()) {
				book = new Book();
				book.setBook_id(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setYear(rs.getString("year"));
				book.setPrice(rs.getInt("price"));
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
		return book;
	}
	
	public List<Book> selectAll(){
		Book book;
		List<Book> list = new ArrayList<Book>();
		PreparedStatement prt = null;
		ResultSet rs = null;
		String sql = "select * from books";
		
		try {
			prt = connection.prepareStatement(sql);
			rs = prt.executeQuery();
			
			while(rs.next()){
				book = new Book();
				book.setBook_id(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setYear(rs.getString("year"));
				book.setPrice(rs.getInt("price"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public void insert(String title, String publisher, String year, int price) {
		String sql = "insert into books values(0,?,?,?,?)";
		PreparedStatement prt = null;

		try {
			prt = connection.prepareStatement(sql);
			prt.setString(1, title);
			prt.setString(2, publisher);
			prt.setString(3, year);
			prt.setInt(4, price);
			prt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(String title, String publisher, int price) {
		String sql = "update books set price=? where title=? and publisher=?";
		PreparedStatement prt = null;

		try {
			prt = connection.prepareStatement(sql);
			prt.setInt(1, price);
			prt.setString(2, title);
			prt.setString(3, publisher);
			prt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(String year) {
		String sql = "delete from books where year=?";
		PreparedStatement prt = null;

		try {
			prt = connection.prepareStatement(sql);
			prt.setString(1, year);
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
