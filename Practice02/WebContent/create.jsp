<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="create" method="get">
		아이디 : <input type="text" name="id"/><br>
		암 &nbsp;&nbsp; 호 : <input type="text" name="pwd"/><br>
		이 &nbsp;&nbsp; 름 : <input type="text" name="name"/><br>
		<input type="submit" value="가입하기">
		<input type="button" value="돌아가기" onclick="location.href='javascript:history.go(-1)'">
	</form>
</body>
</html>