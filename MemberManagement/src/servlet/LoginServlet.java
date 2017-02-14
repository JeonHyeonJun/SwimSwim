package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;
import dto.MemberDao;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	private static final long SerialVersionUIDAdder = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String url = "member/login.jsp";
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("loginUser") != null)
			url = "main.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		String url = "member/login.jsp";
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		
		MemberDao md = MemberDao.getInstance();
		int result = md.userCheck(userid, pwd);
		
		if(result == 1){
			Member member = md.getMember(userid);
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", member);
			req.setAttribute("msg", "회원 가입에 성공했습니다.");
			url = "main.jsp";
		}
		else if(result == 0){
			req.setAttribute("msg", "비밀번호가 맞지 않습니다.");
		}
		else if(result == -1){
			req.setAttribute("msg", "존재하지 않는 회원입니다.");
		}
		
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
}
