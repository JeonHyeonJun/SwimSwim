package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest.do")
public class AjaxTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		resp.setContentType("text/html; charset=UTF-8");	//아 한글성정 극혐
		System.out.println("와라 편의점!");
//		System.out.println(req.getParameter("param1"));
//		System.out.println(req.getParameter("param2"));
		PrintWriter pw = resp.getWriter();
		pw.print("안녕하신가. 힘쎄고 강한아침!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
//		System.out.println("와라 포스트!");
//		System.out.println(req.getParameter("param1"));
//		System.out.println(req.getParameter("param2"));
		int serverSelect = (int)((Math.random()*3)+1);
		int b = Integer.parseInt(req.getParameter("param1"));
		int result = 0;
		
		if((b+1)%3 == serverSelect%3){
			result=1;
		}
		else if((b+2)%3 == serverSelect%3){
			result=2;
		}
		else if(b == serverSelect){
			result=3;
		}
		resp.setContentType("application/xml");
		PrintWriter pw = resp.getWriter();
//		pw.print(a+","+result);
		
//		pw.println("<result>");
//		pw.println("<serverSelect>");
//		pw.println(serverSelect);
//		pw.println("</serverSelect>");
//		pw.println("<compareResult>");
//		pw.println(result);
//		pw.println("</compareResult>");
//		pw.println("</result>");
		
		pw.println("{");
		pw.println("	\"result\" : {");
		pw.println("		\"serverSelect\" : " + serverSelect + ",");
		pw.println("		\"compareResult\" : " + result);
		pw.println("	}");
		pw.println("}");
	}
	
	
}
