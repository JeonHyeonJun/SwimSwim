package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao instance;
	
	private MemberDao(){}

	public static MemberDao getInstance() {
		if(instance==null)
			instance = new MemberDao();
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context ic = new InitialContext();
		DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/login_db");
		Connection con = ds.getConnection();
		return con;
	}
	
	public void createMember(Member member){
		String sql = "insert into member values(?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPass());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Member> selectAll(){
		String sql = "select * from member";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		
		try {
			con = getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				Member member = new Member();
				member.setName(rs.getString(1));
				member.setId(rs.getString(2));
				member.setPass(rs.getString(3));
				list.add(member);
			}
		} catch (Exception e) {
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
