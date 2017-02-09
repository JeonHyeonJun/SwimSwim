<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재고 삭제 완료</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
%>
<center>
<h3>재고 삭제</h3><hr>
<%
	out.println(msg);
%>
<br>
<input type="button" value="돌아가기" onclick="location.href='<%=application.getContextPath()%>/main/main.jsp'">
</center>
</body>
</html>