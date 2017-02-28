package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Member;
import member.MemberDao;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String msg = null;
		
		
		
		MemberDao md = MemberDao.getInstance();
		
		
		if(md.selectOne(id) != null){
			msg = "id 중복입니다.";
		}
		else if(md.selectName(name) != null)
			msg = "닉네임 중복입니다.";
		else{
			Member member = new Member();
			member.setName(name);
			member.setId(id);
			member.setPass(pass);
			md.createMember(member);
			msg = "가입이 완료되었습니다.";
		}
		PrintWriter pw = resp.getWriter();
		pw.println("{");
		pw.println("	\"result\" : {");
		pw.println("		\"msg\" : \"" + msg +"\"");
		pw.println("	}");
		pw.println("}");
	}
	
}