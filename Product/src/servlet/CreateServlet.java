package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StockDao;
import model.Stock;

@WebServlet("*.do")
public class CreateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String contextPath = req.getContextPath()+"/";
		if(req.getRequestURI().equals(contextPath + "delete.do")){
			String code = req.getParameter("code");
			StockDao sd = StockDao.getInstance();
			Stock stock = new Stock();
			stock.setCode(code);
			sd.deleteStock(stock);
			resp.sendRedirect("list.do");
		}
		if(req.getRequestURI().equals(contextPath + "update.do")){
			String code = req.getParameter("code");
			String name = req.getParameter("name");
			int cnt = Integer.parseInt(req.getParameter("cnt"));
			Stock stock = new Stock();
			stock.setCode(code);
			stock.setName(name);
			stock.setCnt(cnt);
			StockDao.getInstance().updateStock(stock);
			resp.sendRedirect("list.do");
		}
		if(req.getRequestURI().equals(contextPath + "codeCheck.do")){
			String code = req.getParameter("code");
			StockDao sd = StockDao.getInstance();
			Stock stock = sd.selectCode(code);
			boolean result = stock == null ? true:false;
			String resultStr = "{\"result\" : " +result+ "}";
			resp.getWriter().println(resultStr);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String contextPath = req.getContextPath()+"/";
		if(req.getRequestURI().equals(contextPath + "create.do")){
		
		String code = req.getParameter("code");
		String name = req.getParameter("name");
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		StockDao sd = StockDao.getInstance();
		if(sd.selectCode(code) == null){
			Stock stock = new Stock();
			stock.setCode(code);
			stock.setName(name);
			stock.setCnt(cnt);
			sd.createStock(stock);
			resp.sendRedirect("list.do");
		}
		else
			resp.sendRedirect("list.do");
		}
	}
	
}
