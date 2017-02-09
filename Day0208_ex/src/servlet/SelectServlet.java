package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StockDao;
import model.Stock;

@WebServlet("/select")
public class SelectServlet extends HttpServlet{
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StockDao dao = StockDao.getInstance();
		String select = req.getParameter("select");
		
		
	
		
		Stock stock = new Stock();
		List<Stock> list = new ArrayList<Stock>();
		List<Stock> listAll = dao.selectAll();
		
		if(select.equals("1")){
			String code = req.getParameter("code");
			stock = dao.selectCode(code);
			if(stock !=null){
				req.setAttribute("stock", stock);
				req.getRequestDispatcher("select/select_complete.jsp").forward(req, resp);
			}
			else
				resp.sendRedirect("select/select_complete.jsp");
		}
		else if(select.equals("2")){
			String name = req.getParameter("name");
			list = dao.selectName(name);
			req.setAttribute("list", list);
			req.getRequestDispatcher("select/select_complete.jsp").forward(req, resp);
		}
		else if(select.equals("3")){
			int cnt = Integer.parseInt(req.getParameter("cnt"));
			String type = req.getParameter("type");
			
			if(type.equals("1")){
				for(int i=0; i<listAll.size(); i++){
					if(listAll.get(i).getCnt() >= cnt){
						list.add(listAll.get(i));
					}
				}
				req.setAttribute("list", list);
				req.getRequestDispatcher("select/select_complete.jsp").forward(req, resp);
			}
			else if(type.equals("2")){
				for(int i=0; i<listAll.size(); i++){
					if(listAll.get(i).getCnt() <= cnt){
						list.add(listAll.get(i));
					}
				}
				req.setAttribute("list", list);
				req.getRequestDispatcher("select/select_complete.jsp").forward(req, resp);
			}
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
		resp.setCharacterEncoding("UTF-8");
		doProc(req,resp);
	}

}
