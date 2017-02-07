<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>서블릿</title>
<script type="text/javascript">
	function check() {
		if(document.frm.id.value == ""){
			alert("아이디를 입력해줘요");
			document.frm.id.focus();
			return false;
		}
		else if(document.frm.age.value == ""){
			alert("나이좀 알려줘요");
			document.frm.age.focus();
			return false;
		}
		else if(isNaN(document.frm.age.value)){
			alert("숫자아님ㅗ");
			document.frm.age.focus();
			return false;
		}
		else
			return true;
	}

</script>
</head>
<body>
	<form action="ParamServlet" method="post" name="frm">
		아이디 : <input type="text" name="id"/><br/>
		나 &nbsp; 이 : <input type="text" name="age"/><br/>
		<input type="submit" value="전송" onclick="return check()"/>
		<input type="submit" value="함정" onclick="alert('You just activated my trap card!');return false;"/>
	</form>
</body>
</html>