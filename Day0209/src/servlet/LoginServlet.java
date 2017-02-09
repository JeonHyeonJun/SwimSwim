package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;



public class LoginServlet extends HelloServlet{
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1 = "ddoddoia";
		String pwd1 = "1234";
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if(id.equals(id1) && pwd.equals(pwd1)){
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			resp.sendRedirect("login/loginSuccess.jsp");
		}
		else
			resp.sendRedirect("login/loginFail.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		doProc(req, resp);
	}
	
}
