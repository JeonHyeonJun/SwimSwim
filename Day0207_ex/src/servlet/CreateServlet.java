package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import member.Member;

@WebServlet("/create")
public class CreateServlet extends HttpServlet{
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = "createSuccess.jsp";
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");

		MemberDao md = MemberDao.getInstance();
		List<Member> list = md.selectAll();
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getId().equals(id)){
				type = "createFail.jsp";
			}
		}
		
		if(type.equals("createSuccess.jsp"))
			md.insertMember(id, pwd, name);
		
		req.getRequestDispatcher(type).forward(req, resp);
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
