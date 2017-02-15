package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import controller.ActionFactory;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet{
	private static final long SerialVersionUID = 1L;

	public BoardServlet() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String command = req.getParameter("command");
		System.out.println("BoardServlet에서 요청 받음을 확인" +command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null)
			action.excute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	
}
