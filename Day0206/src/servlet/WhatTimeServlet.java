package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/whatTime.do")
public class WhatTimeServlet extends HttpServlet{
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		resp.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter pw = resp.getWriter();	//HTML코드 출력을 위한 객체
		pw.println("<HTML>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("지금시간은");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println(date);
		pw.println("</body>");
		pw.println("</HTML>");
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
