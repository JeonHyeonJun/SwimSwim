<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����</title>
</head>
<body>
	<%
		String person = request.getParameter("person");
		String sex = request.getParameter("sex");
		String job = request.getParameter("job");
		String[] books = request.getParameterValues("books");
		String comments = request.getParameter("comments");
		
		out.println("�̸�: " +person+"<br>");
		out.println("����: " +sex+"<br>");
		out.println("����: " +job+"<br>");
		for(String s : books)
			out.println("�������: " +s+"<br>");
		out.println("��Ÿ: " +comments);
	%>
</body>
</html>