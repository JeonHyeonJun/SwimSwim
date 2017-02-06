package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addProc.do")
public class AddProcServlet extends HttpServlet{

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		int a = Integer.parseInt(req.getParameter("1"));
		int b = Integer.parseInt(req.getParameter("2"));
		int c = a + b;
//		pw.println("<HTML>");
//		pw.println("<head>");
//		pw.println("<title>");
//		pw.println("결과");
//		pw.println("</title>");
//		pw.println("</head>");
//		pw.println("<body>");
//		pw.println(c);
//		pw.println("</body>");
//		pw.println("</HTML>");
		
		req.setAttribute("result", c);
		req.getRequestDispatcher("addresult.jsp").forward(req, resp);
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
	}
	
}
