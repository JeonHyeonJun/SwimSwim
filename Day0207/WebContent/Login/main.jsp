<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인임다</title>
</head>
<body>
	<%= request.getParameter("name") %>님 안녕!
	<br>
	저희 홈페이지에 방문해 주셔서 감사합니다.
</body>
</html>
