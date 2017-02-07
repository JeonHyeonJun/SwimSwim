package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/layout.do")
public class LayoutServlet extends HttpServlet {

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		String url = req.getContextPath() + "/";
		if (type != null) {
			if (type.equals("loan"))
				url = "../main/loanInput.jsp";
			else if (type.equals("loanresult"))
				url = "../module/loanResult.jsp";
			else if (type.equals("add"))
				url = "../main/addInput.jsp";
			else if (type.equals("addresult"))
				url = "../module/addresult.jsp";
			else if (type.equals("date"))
				url = "../module/whatTime.jsp";
			
			
			req.setAttribute("url", url);
			req.getRequestDispatcher("main/layout.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

}
