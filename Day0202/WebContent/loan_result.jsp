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
		double bb = (b / 100) / 12;
		double c = Integer.parseInt(month);
		double d = Math.pow((1 + bb), c);
		double ejasum = 0;
		if (select.equals("onerigm")) {
			double result = ((a * bb) * d) / (d - 1);
			int result2 = (int)(result+0.5);
			
			
		
	%>
	<table border=1>
		<th>����ݾ�</th>
		<th>����Ⱓ</th>
		<th>����ݸ�</th>
		<th>��ȯ��</th>
		<tr>
			<td><%=money %>��</td>
			<td><%=month %>����</td>
			<td><%=gmri %>%</td>
			<td><%=result2 %>��</td>
		</tr>
		</table>
		<table border=1>
			<th>ȸ��</th>
			<th>��ȯ��</th>
			<th>����</th>
			<th>����</th>
			<th>�ܾ�</th>
			<th>������</th>>
			<%
			for (int i = 0; i < c; i++) {
				double eja = a*bb;
				int eja2 = (int)(eja+0.5);
				double one = result-eja;
				int one2 = (int)(one+0.5);
				double zan = a-one;
				int zan2 = (int)(zan+0.5);
				
				ejasum += eja;
				int ejasum2 = (int)(ejasum+0.5);
				out.println("<tr>");
				
				out.println("<td>"+(i+1)+"</td>");
				out.println("<td>"+result2+"��</td>");
				out.println("<td>"+one2+"��</td>");
				out.println("<td>"+eja2+"��</td>");
				out.println("<td>"+zan2+"��</td>");
				out.println("<td>"+ejasum2+"��</td>");
				
				a = zan;
			}
		%>
		</table>
		<%
		}
		else if(select.equals("onegm")){
			double result = a/c;
			int result2 = (int)(result+0.5);
		%>
			<table border=1>
				<th>����ݾ�</th>
				<th>����Ⱓ</th>
				<th>����ݸ�</th>
				<th>��ȯ��</th>
				<tr>
					<td><%=money %>��</td>
					<td><%=month %>����</td>
					<td><%=gmri %>%</td>
					<td><%=result2 %>��</td>
				</tr>
				</table>
				<table border=1>
					<th>ȸ��</th>
					<th>��ȯ��</th>
					<th>����</th>
					<th>����</th>
					<th>�ܾ�</th>
					<th>������</th>
					<%
					for (int i = 0; i < c; i++) {
						double eja = a*bb;
						int eja2 = (int)(eja+0.5);
						double sang = result+eja;
						int sang2 = (int)(sang+0.5);
						double zan = a-result;
						int zan2 = (int)(zan+0.5);
						
						ejasum += eja;
						int ejasum2 = (int)(ejasum+0.5);
						out.println("<tr>");
						
						out.println("<td>"+(i+1)+"</td>");
						out.println("<td>"+sang2+"��</td>");
						out.println("<td>"+result2+"��</td>");
						out.println("<td>"+eja2+"��</td>");
						out.println("<td>"+zan2+"��</td>");
						out.println("<td>"+ejasum2+"��</td>");
						
						a = zan;
					}
					%>
					</table>
					<%} %>
				
</body>
</html>