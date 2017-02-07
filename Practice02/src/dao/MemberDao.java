package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.Member;

public class MemberDao {
	private Connection connection;
	private static MemberDao instance;
	private static String URL = "jdbc:mysql://127.0.0.1/member_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	
	
	
	public static MemberDao getInstance() {
		if(instance == null)
			instance = new MemberDao();
		return instance;
	}

	private MemberDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertMember(String id, String pwd, String name){
		String sql = "insert into member values(?,?,?)";
		PreparedStatement pst = null;
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pwd);
			pst.setString(3, name);
			int result = pst.executeUpdate();
			if(result > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(pst != null)
					pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void updateMember(String id, String pwd, String pwd2){
		String sql = "update member set pwd=? where id=? and pwd=?";
		PreparedStatement pst = null;
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, pwd2);
			pst.setString(2, id);
			pst.setString(3, pwd);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pst != null)
					pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteMember(String id){
		String sql = "delete from member where id=?";
		PreparedStatement pst = null;
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pst != null)
					pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Member selectOne(String id){
		String sql = "select * from member";
		Member member = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				if(id.equals(rs.getString(1))){
					member = new Member();
					member.setId(rs.getString(1));
					member.setPwd(rs.getString(2));
					member.setName(rs.getString(3));
					return member;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pst != null)
					pst.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	
	public List<Member> selectAll(){
		String sql = "select * from member";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				Member member = new Member();
				member.setId(rs.getString(1));
				member.setPwd(rs.getString(2));
				member.setName(rs.getString(3));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pst != null)
					pst.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
