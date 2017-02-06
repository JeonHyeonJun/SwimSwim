package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);		//get방식의 요청이 오면 수행되는 메소드
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = resp.getWriter();	//HTML코드 출력을 위한 객체
		pw.println("<HTML>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("제목학원");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>Hell World!</h1>");
		pw.println("</body>");
		pw.println("</HTML>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);	//post방식의 요청이 오면 수행되는 메소드
	}
	
}
