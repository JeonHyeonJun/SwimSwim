package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import dto.MemberDao;

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String userid = req.getParameter("userid");
		MemberDao md = MemberDao.getInstance();
		
		Member member = md.getMember(userid);
		req.setAttribute("member", member);
		
		req.getRequestDispatcher("member/memberUpdate.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String admin = req.getParameter("admin");
		
		Member member = new Member();
		member.setUserid(userid);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(Integer.parseInt(admin));
		
		MemberDao md = MemberDao.getInstance();
		
		md.updateMember(member);
		resp.sendRedirect("login.do");
	}
	
}
