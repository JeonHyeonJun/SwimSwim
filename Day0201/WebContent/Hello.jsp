<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>시간때우기</title>
<%
	Date date = new Date();
%>
</head>
<body>
Hello World<br>
안녕 세계<br>
곤니치와 세카이<br>
<% 
	if( date.getHours() < 12)
	{
		out.println("오전이네");
	}
	else
	{
		out.println("오후네");
	}
%>
현재시간 : <%= date %> 
</body>
</html>