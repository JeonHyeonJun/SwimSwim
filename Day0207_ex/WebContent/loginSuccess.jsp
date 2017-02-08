<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String)request.getAttribute("id");
		String name = (String)request.getAttribute("name");
		Cookie cookie = new Cookie("id", id);
		cookie.setMaxAge(365*24*60*60);
		response.addCookie(cookie);
		response.addCookie(new Cookie("name",name));
	%>
	로그인성공<br>
	<a href="getCookies.jsp">쿠키보기</a><br>
	<%= name %>님의 방문을 환영합니다!<br>
	<input type="button" value="메인으로" onclick="location.href='start.jsp'">
</body>
</html>