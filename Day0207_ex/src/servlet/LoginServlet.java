package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import member.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		Member member = MemberDao.getInstance().selectOne(id);
		
		if(member != null){
			if(member.getId().equals(id) && member.getPwd().equals(pwd)){
				req.setAttribute("name", member.getName());
				req.setAttribute("id", member.getId());
				req.getRequestDispatcher("loginSuccess.jsp").forward(req, resp);
				return;
			}
			else
				resp.sendRedirect("loginFail.jsp");
		}
		else
			resp.sendRedirect("loginFail.jsp");
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
