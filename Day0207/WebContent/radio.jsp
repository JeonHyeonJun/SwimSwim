<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인정보유출</title>
</head>
<body>
	<form action="RadioServlet" method="get">
	<input type="radio" id="gender" name="gender" value="남자" checked>XY염색체
	<input type="radio" id="gender" name="gender" value="여자">XX염색체<br><br>
	<label for="chk_mail">메이 정보 수신 여부 : </label>
	<input type="radio" id="chk_mail" name="chk_mail" value="yes" checked>수신
	<input type="radio" id="chk_mail" name="chk_mail" value="no">거부<br><br>
	<label for="content">간단한 가입 인사를 적어주세요 ^오^</label>
	<textarea id="content" name="content" rows="3" cols="35"></textarea><br>
	<input type="submit" value="전송">
	</form>
</body>
</html>