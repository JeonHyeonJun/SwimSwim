<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>b</title>
</head>
<body>
	<%
	System.out.println("b�Դϴ�");
	String param = request.getParameter("name");
	System.out.println(param);	
	%>
	Hello. I'm Veronica
</body>
</html>