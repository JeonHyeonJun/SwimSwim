<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Loan"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>너의 갚을돈은</title>

</head>
<body>
	<%
		double a = Integer.parseInt(request.getParameter("money"));
		double b = Integer.parseInt(request.getParameter("gmri"));
		double b_month = (b / 100) / 12;
		int c = Integer.parseInt(request.getParameter("month"));
		double d = Math.pow((1 + b_month), c);
		String select = request.getParameter("select");
		
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
		request.setAttribute("result", list);
	%>
<jsp:forward page="loan_result.jsp"></jsp:forward>
		
		
</body>
</html>