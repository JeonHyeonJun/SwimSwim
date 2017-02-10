<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL과 JSTL 기본</title>
</head>
<body>
	${"Hell1!"}<br>	<!-- 표현언어(EL) -->
	<%= "Hell2!" %><br> <!-- 표현식 -->
	<% out.println("Hell3!"); %><br> <!-- 스크립트릿 -->
</body>
</html>