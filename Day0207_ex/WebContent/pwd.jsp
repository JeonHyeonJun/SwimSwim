<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보수정</title>
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
		else if(document.frm.pwd2.value == ""){
			alert("변경할 암호를 입력하세요!");
			document.frm.pwd2.focus();
			return false;
		}
		else
			return true;
	}
</script>
</head>
<body>
	<form action="pwd" method="post" name="frm">
		아이디 : <input type="text" name="id"/><br>
		암 &nbsp;&nbsp; 호 : <input type="password" name="pwd"/><br>
		변경할암호 : <input type="password" name="pwd2"/><br>
		<input type="submit" value="변경" onclick="return check()">
		<input type="button" value="돌아가기" onclick="location.href='javascript:history.go(-1)'">
	</form>
</body>
</html>