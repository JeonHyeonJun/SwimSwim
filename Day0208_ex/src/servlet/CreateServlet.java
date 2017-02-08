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

@WebServlet("/create")
public class CreateServlet extends HttpServlet{
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean check = true;
		Stock stock = new Stock();
		stock.setCode(req.getParameter("code"));
		stock.setName(req.getParameter("name"));
		stock.setCnt(Integer.parseInt(req.getParameter("cnt")));
		
		if(stock.getCnt()<0){
			check=false;
			String msg = "재고량이 음수입니다.";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("create/create_false.jsp").forward(req, resp);
		}

		StockDao sd = StockDao.getInstance();
		List<Stock> list = sd.selectAll();
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getCode().equals(stock.getCode())){
				check=false;
				String msg = "중복된 상품코드입니다.";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("create/create_false.jsp").forward(req, resp);
				return;
			}
			
		}
		
		if(check == true){
			sd.createStock(stock);
			resp.sendRedirect("create/create_complete.jsp");
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
