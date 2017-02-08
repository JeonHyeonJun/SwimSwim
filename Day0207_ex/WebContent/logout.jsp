<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키폐기</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("id","");
		cookie.setMaxAge(0);	//쿠키의 유효기간을 만료시킴
		response.addCookie(cookie);
		cookie = new Cookie("name","");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	%>
	<h3>로그아웃되었습니다 </h3><br>
	<input type="button" value="메인으로" onclick="location.href='start.jsp'">
	</a>
</body>
</html>