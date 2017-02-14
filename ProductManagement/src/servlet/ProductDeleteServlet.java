package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Product.Product;
import Product.ProductDao;

@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet{
	private static final long SerialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String code = req.getParameter("code");
		
		ProductDao pd = ProductDao.getInstance();
		Product product = pd.selectProductByCode(code);
		
		req.setAttribute("product", product);
		req.getRequestDispatcher("product/productDelete.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		String code = req.getParameter("code");
		
		ProductDao pd = ProductDao.getInstance();
		pd.deleteProduct(code);
		
		resp.sendRedirect("productList.do");
	}
	
}
