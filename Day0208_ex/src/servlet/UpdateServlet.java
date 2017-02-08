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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Stock stock = new Stock();
		String type = req.getParameter("type");
		stock.setCode(req.getParameter("code"));
		stock.setCnt(Integer.parseInt(req.getParameter("cnt")));
		
		StockDao sd = StockDao.getInstance();
		sd.selectCode(stock.getCode());
		
		if(sd.selectCode(stock.getCode()) != null){
			if(type.equals("1")){
				int result = (sd.selectCode(stock.getCode()).getCnt())+(stock.getCnt());
				stock.setCnt(result);
				sd.updateStock(stock);
				resp.sendRedirect("update/update_complete.jsp");
			}
			else if(type.equals("2")){
				int result = (sd.selectCode(stock.getCode()).getCnt())-(stock.getCnt());
				System.out.println(result);
				if(result>=0){
					stock.setCnt(result);
					sd.updateStock(stock);
					resp.sendRedirect("update/update_complete.jsp");
				}
				else{
					String msg = "남은 재고량이 제거하려는 재고량보다 적습니다.";
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("update/update_false.jsp").forward(req, resp);;
				}
					
			}
		}
		else{
			String msg = "존재하지 않는 상품코드입니다.";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("update/update_false.jsp").forward(req, resp);;
		}
		
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
		resp.setCharacterEncoding("UTF-8");
		doProc(req, resp);
	}
	
}
