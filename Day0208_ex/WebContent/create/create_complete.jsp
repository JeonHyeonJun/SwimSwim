<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등록완료</title>
</head>
<body>
<center>
<h3>등록완료</h3><hr>
	등록이 완료되었습니다.<input type="button" value="돌아가기" onclick="location.href='<%=application.getContextPath()%>/main/main.jsp'"><br>
	<img src="<%= application.getContextPath()%>/img/good.jpg" onclick="location.href='<%=application.getContextPath()%>/main/main.jsp'">
	
	</center>
</body>
</html>