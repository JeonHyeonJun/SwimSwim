package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDao;

@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet{
	private static final long SerialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String userid = req.getParameter("userid");
		
		MemberDao md = MemberDao.getInstance();
		
		int result = md.confirmID(userid);
		
		req.setAttribute("userid", userid);
		req.setAttribute("result", result);
		req.getRequestDispatcher("member/idcheck.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	}
	
}
