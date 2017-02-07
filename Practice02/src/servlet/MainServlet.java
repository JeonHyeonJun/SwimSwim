package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String url ="";
		String type = req.getParameter("type");
		
		if(type.equals("create")){
			resp.sendRedirect("create.jsp");
		}
		
		else if(type.equals("login")){
			resp.sendRedirect("login.jsp");
		}
		else if(type.equals("pwd")){
			resp.sendRedirect("pwd.jsp");
		}
		else if(type.equals("delete")){
			resp.sendRedirect("delete.jsp");
		}
		else if(type.equals("list")){
			resp.sendRedirect("list.jsp");
		}
		else if(type.equals("listAll")){
			req.getRequestDispatcher("viewAllMember.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	}
	
}
