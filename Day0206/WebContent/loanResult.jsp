<%@page import="java.util.List"%>
<%@page import="model.Loan" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�и�</title>
</head>
<body>
	<table border=1>
		<th>ȸ��</th>
		<th>��ȯ��</th>
		<th>����</th>
		<th>����</th>
		<th>�ܾ�</th>

		<%
		//class�� ������ java���Ϸ� ���� import �������!
			List<Loan> list = (List)request.getAttribute("result");
			for (int j = 0; j < list.size(); j++) {
				Loan loan = list.get(j);
					out.println("<tr>");
					out.println("<td>" + loan.idx + "</td>");
					out.println("<td>" + loan.thisMonthOrigin + "��</td>");
					out.println("<td>" + loan.thisMonthRate + "��</td>");
					out.println("<td>" + loan.amount + "��</td>");
					out.println("<td>" + loan.readyMonth + "��</td>");
				}
				out.println("</table>");
		%>
</body>
</html>