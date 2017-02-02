<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구구단표로만들기</title>
</head>
<body>
<table border="1">
	
	<%
		for(int i=1; i<10; i++){
			out.println("<tr>");
			for(int j=1; j<10; j++){
				out.println("<td>"+j+"*"+i+"="+i*j+"</td>");
				//out.println("<td align=\"right\">"+i*j+"</td>");
			}
			out.println("</tr>");
		}
	%>
	
</table>
</body>
</html>