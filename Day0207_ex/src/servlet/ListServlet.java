package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import member.Member;

@WebServlet("/list")
public class ListServlet extends HttpServlet{
	
	public String getCookieValue(Cookie[] cookies, String name){
		for(Cookie c : cookies){
			if(c.getName().equals(name))
				return c.getValue();
		}
		return null;
	}
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		if(getCookieValue(cookies, "id") == null || getCookieValue(cookies, "name") == null)
			resp.sendRedirect("login.jsp");
		else{
			MemberDao md = MemberDao.getInstance();
			List<Member> list = md.selectAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("main?type=listAll").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//		resp.setCharacterEncoding("UTF-8");
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//		resp.setCharacterEncoding("UTF-8");
//		doProc(req, resp);
	}
	
}
