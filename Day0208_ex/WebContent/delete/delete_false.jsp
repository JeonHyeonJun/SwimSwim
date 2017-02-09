<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재고 삭제 실패</title>
</head>
<body>
<center>
<h3>재고 삭제 실패</h3><hr>
<%
	String msg = (String)request.getAttribute("msg");
	out.println(msg);
%>
<input type="button" value="돌아가기" onclick="location.href='<%=application.getContextPath() %>/main/main.jsp'"><br>
<img src="<%= application.getContextPath()%>/img/sad.jpg" onclick="location.href='<%=application.getContextPath()%>/main/main.jsp'">
</center>
</body>
</html>