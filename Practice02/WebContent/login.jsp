<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="login" method="post">
		아이디 : <input type="text" name="id"/><br>
		암 &nbsp;&nbsp; 호 : <input type="password" name="pwd"/><br>
		<input type="submit" value="로그인">
		<input type="button" value="돌아가기" onclick="location.href='javascript:history.go(-1)'">
	</form>
</body>
</html>