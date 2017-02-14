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

@WebServlet("/join.do")
public class JoinSevlet extends HttpServlet{
	private static final long SerialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.getRequestDispatcher("member/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String admin = req.getParameter("admin");
		
		Member member = new Member();
		member.setName(name);
		member.setUserid(userid);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(Integer.parseInt(admin));
		
		MemberDao md = MemberDao.getInstance();
		int result = md.insertMember(member);
		
		HttpSession session = req.getSession();
		
		if(result == 1){
			session.setAttribute("userid", member.getUserid());
			req.setAttribute("msg", "회원 가입에 성공하셨습니다!"+result);
		}
		else {
			req.setAttribute("msg", "회원 가입에 실패하셨습니다!!!"+result);
		}
		
		req.getRequestDispatcher("member/login.jsp").forward(req, resp);
	}
	
}
