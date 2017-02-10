package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addition")
public class AdditionServlet extends HttpServlet{
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = 20;
		int num2 = 10;
		int add = num1+num2;
		String gilsun = "게이";
		
		req.setAttribute("num1", num1);
		req.setAttribute("num2", num2);
		req.setAttribute("add", add);
		req.setAttribute("gilsun", gilsun);
		
		req.getRequestDispatcher("07_addition.jsp").forward(req, resp);;
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
