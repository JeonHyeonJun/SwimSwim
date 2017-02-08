<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
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
		else if(document.frm.name.value == ""){
			alert("이름을 입력하세요!");
			document.frm.name.focus();
			return false;
		}
		else
			return true;
	}
</script>
</head>
<body>
	<form action="create" method="get" name="frm">
		아이디 : <input type="text" name="id"/><br>
		암 &nbsp;&nbsp; 호 : <input type="password" name="pwd"/><br>
		이 &nbsp;&nbsp; 름 : <input type="text" name="name"/><br>
		<input type="submit" value="가입하기" onclick="return check()">
		<input type="button" value="돌아가기" onclick="location.href='javascript:history.go(-1)'">
	</form>
</body>
</html>