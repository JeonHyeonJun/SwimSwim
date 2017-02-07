<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		if(isNaN(document.frm.num.value)){
			alert("숫자아님ㅗ");
			document.frm.num.focus();
			return false;
		}
		else 
			return true;
	}
</script>
</head>
<body>
	<form action="goToNaver" method="get" name="frm">
	숫자를 입력하세요<input type="text" name="num"><br>
	<input type="submit" value="출발" onclick="return check()">
	<!-- input type="button" onclick="location.href='goToNaver'" value="네이버로가기" -->
	</form>
</body>
</html>