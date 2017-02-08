<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script type="text/javascript">
	function check() {
		if(document.frm.id.value == ""){
			alert("아이디를 입력하세요!");
			document.frm.id.focus();
			return false;
		}
		else if(document.frm.pwd.value == ""){
			alert("암호를 입력하세요!");
			document.frm.pwd.focus();
			return false;
		}
		else
			return true;
	}
</script>
</head>
<body>
	<form action="login" method="post" name="frm">
		아이디 : <input type="text" name="id"/><br>
		암 &nbsp; 호 : <input type="password" name="pwd"/><br>
		<input type="submit" value="로그인" onclick="return check()">
		<input type="button" value="돌아가기" onclick="location.href='start.jsp'">
	</form>
</body>
</html>