<%@page import="java.util.List"%>
<%@page import="model.Loan"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�и�</title>
</head>
<body>
	<table border="1" width="1024" height="768">
		<tr height="100">
			<td colspan="2"><jsp:include page="header.jsp" flush="false"></jsp:include>
			</td>
		</tr>
		<tr height="300">
			<td align="left" width="100"><jsp:include page="left.jsp"
					flush="false"></jsp:include></td>
			<td>
				<table border=1>
					<th>ȸ��</th>
					<th>��ȯ��</th>
					<th>����</th>
					<th>����</th>
					<th>�ܾ�</th>

					<%
						//class�� ������ java���Ϸ� ���� import �������!
						List<Loan> list = (List) request.getAttribute("result");
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
				
			</td>
		</tr>
		<tr height="100">
			<td colspan="2"><jsp:include page="footer.jsp" flush="false"></jsp:include>
			</td>
		</tr>
	</table>

</body>
</html>