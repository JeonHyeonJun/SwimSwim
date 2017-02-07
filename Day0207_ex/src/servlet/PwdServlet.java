package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import member.Member;

@WebServlet("/pwd")
public class PwdServlet extends HttpServlet{

	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String pwd2 = req.getParameter("pwd2");
		
		MemberDao md = MemberDao.getInstance();
		Member member = md.selectOne(id);
		if(member.getId().equals(id) && member.getPwd().equals(pwd)){
			md.updateMember(id, pwd, pwd2);
			resp.sendRedirect("main.jsp");
		}
		else
			resp.sendRedirect("pwd.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		resp.setCharacterEncoding("UTF-8");
		doProc(req, resp);
	}
	
}
