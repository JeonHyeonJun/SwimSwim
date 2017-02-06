<%@page import="java.util.List"%>
<%@page import="model.Loan" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>론리</title>
</head>
<body>
	<table border=1>
		<th>회차</th>
		<th>상환금</th>
		<th>원금</th>
		<th>이자</th>
		<th>잔액</th>

		<%
		//class를 받을땐 java파일로 만들어서 import 해줘야함!
			List<Loan> list = (List)request.getAttribute("result");
			for (int j = 0; j < list.size(); j++) {
				Loan loan = list.get(j);
					out.println("<tr>");
					out.println("<td>" + loan.idx + "</td>");
					out.println("<td>" + loan.thisMonthOrigin + "원</td>");
					out.println("<td>" + loan.thisMonthRate + "원</td>");
					out.println("<td>" + loan.amount + "원</td>");
					out.println("<td>" + loan.readyMonth + "원</td>");
				}
				out.println("</table>");
		%>
</body>
</html>