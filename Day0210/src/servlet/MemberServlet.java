package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{

	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Member member = new Member("티모", "Timo");
		
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("오니짱","ㅇㅇ"));
		list.add(new Member("오니짱","ㅇㅇ"));
		list.add(new Member("오니짱","ㅇㅇ"));
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("09_el.jsp").forward(req, resp);
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
