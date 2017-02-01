<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구구단을 외자</title>
</head>
<body>
<%
	int a = 2;
	for(int i=1; i<10; i++)
	{
		out.println(a+" * "+i+" = "+a*i+"&nbsp;&nbsp;&nbsp;&nbsp;");


	if(i%3 == 0){
		out.println("<br>");
	}
	}
%>


</body>
</html>