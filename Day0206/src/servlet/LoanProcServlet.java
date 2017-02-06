package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loan;

@WebServlet("/loanProc.do")
public class LoanProcServlet extends HelloServlet{
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double a = Integer.parseInt(req.getParameter("money"));
		double b = Integer.parseInt(req.getParameter("gmri"));
		double b_month = (b / 100) / 12;
		int c = Integer.parseInt(req.getParameter("month"));
		double d = Math.pow((1 + b_month), c);
		String select = req.getParameter("select");
		
		List<Loan> list = new ArrayList<Loan>();
		
		if (select.equals("onerigm")) {
			double result = ((a * b_month) * d) / (d - 1);
			int result2 = (int) (result + 0.5);
			for (int i = 0; i < c; i++) {
				Loan loan = new Loan();
				double eja = a * b_month;
				int eja2 = (int) (eja + 0.5);
				double one = result - eja;
				int one2 = (int) (one + 0.5);
				double zan = a - one;
				int zan2 = (int) (zan + 0.5);
				loan.idx = i+1;
				loan.thisMonthOrigin = result2;
				loan.thisMonthRate = one2;
				loan.amount = eja2;
				loan.readyMonth = zan2;
				list.add(loan);
				a= zan;
			}
		}
		else if (select.equals("onegm")) {
			double result = a / c;
			int result2 = (int) (result + 0.5);
			for (int i = 0; i < c; i++) {
				Loan loan = new Loan();
				double eja = a * b_month;
				int eja2 = (int) (eja + 0.5);
				double sang = result + eja;
				int sang2 = (int) (sang + 0.5);
				double zan = a - result;
				int zan2 = (int) (zan + 0.5);
				loan.idx = i+1;
				loan.thisMonthOrigin = sang2;
				loan.thisMonthRate = result2;
				loan.amount = eja2;
				loan.readyMonth = zan2;
				list.add(loan);
				a= zan;
			}
		}
		req.setAttribute("result", list);
		req.getRequestDispatcher("loanResult.jsp").forward(req, resp);
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
