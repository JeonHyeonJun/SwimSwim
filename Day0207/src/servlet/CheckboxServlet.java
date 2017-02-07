package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		String items[] = req.getParameterValues("item");
		if(items == null)
			out.println("우리의 돈줄이 아닙니다");
		else {
			out.println("당신이 선택한 항목이 결제되었습니다.<hr>");
			for(String item : items)
				out.print(item + " ");
		}
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.println("</body></html>");
		out.close();
	}
	
}
