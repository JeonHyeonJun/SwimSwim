<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ��������</title>
</head>
<body>
	<%
		String money = request.getParameter("money");
		String gmri = request.getParameter("gmri");
		String month = request.getParameter("month");
		String select = request.getParameter("select");
		double a = Integer.parseInt(money);
		double b = Integer.parseInt(gmri);
		double b_month = (b / 100) / 12;
		int c = Integer.parseInt(request.getParameter("month"));
		double d = Math.pow((1 + b_month), c);
		int[] sanghwan = new int[c];
		int[] onegm = new int[c];
		int[] e = new int[c];
		int[] jan = new int[c];
		if (select.equals("onerigm")) {
			double result = ((a * b_month) * d) / (d - 1);
			int result2 = (int) (result + 0.5);
			for (int i = 0; i < c; i++) {
				double eja = a * b_month;
				int eja2 = (int) (eja + 0.5);
				double one = result - eja;
				int one2 = (int) (one + 0.5);
				double zan = a - one;
				int zan2 = (int) (zan + 0.5);
				onegm[i] = one2;
				e[i] = eja2;
				jan[i] = zan2;
				a = zan;
			}
	%>
	<table border=1>
		<th>����ݾ�</th>
		<th>����Ⱓ</th>
		<th>����ݸ�</th>
		<th>��ȯ��</th>
		<tr>
			<td><%=money%>��</td>
			<td><%=month%>����</td>
			<td><%=gmri%>%</td>
			<td><%=result2%>��</td>
		</tr>
	</table>
	<table border=1>
		<th>ȸ��</th>
		<th>��ȯ��</th>
		<th>����</th>
		<th>����</th>
		<th>�ܾ�</th>

		<%
			for (int j = 0; j < c; j++) {
					out.println("<tr>");
					out.println("<td>" + (j + 1) + "</td>");
					out.println("<td>" + result2 + "��</td>");
					out.println("<td>" + onegm[j] + "��</td>");
					out.println("<td>" + e[j] + "��</td>");
					out.println("<td>" + jan[j] + "��</td>");
				}
				out.println("</table>");
			} 
			else if (select.equals("onegm")) {
				double result = a / c;
				int result2 = (int) (result + 0.5);
				for (int i = 0; i < c; i++) {
					double eja = a * b_month;
					int eja2 = (int) (eja + 0.5);
					double sang = result + eja;
					int sang2 = (int) (sang + 0.5);
					double zan = a - result;
					int zan2 = (int) (zan + 0.5);
					a = zan;
					sanghwan[i] = sang2;
					e[i] = eja2;
					jan[i] = zan2;
				}
		%>
		<table border=1>
			<th>����ݾ�</th>
			<th>����Ⱓ</th>
			<th>����ݸ�</th>
			<th>��ȯ��</th>
			<tr>
				<td><%=money%>��</td>
				<td><%=month%>����</td>
				<td><%=gmri%>%</td>
				<td><%=result2%>��</td>
			</tr>
		</table>
		<table border=1>
			<th>ȸ��</th>
			<th>��ȯ��</th>
			<th>����</th>
			<th>����</th>
			<th>�ܾ�</th>

			<%
				for (int j = 0; j < c; j++) {
						out.println("<tr>");
						out.println("<td>" + (j + 1) + "</td>");
						out.println("<td>" + sanghwan[j] + "��</td>");
						out.println("<td>" + result2 + "��</td>");
						out.println("<td>" + e[j] + "��</td>");
						out.println("<td>" + jan[j] + "��</td>");
					}
					out.println("</table>");
				}
			%>
		
</body>
</html>