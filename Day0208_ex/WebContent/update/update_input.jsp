<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재고변경</title>
<script type="text/javascript">
	function check() {
		if(document.frm.code.value == ""){
			alert("상품코드를 입력하세요!");
			document.frm.code.focus();
			return false;
		}
		else if(document.frm.cnt.value == ""){
			alert("재고량을 입력하세요!");
			document.frm.cnt.focus();
			return false;
		}
		else if(isNaN(document.frm.cnt.value)){
			alert("재고량은 숫자로 입력하세요!");
			document.frm.cnt.focus();
			return false;
		}
		else if(document.frm.cnt.value.length >3){
			alert("재고량은 999까지 입력가능합니다.");
			document.frm.cnt.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="../update" method="post" name="frm">
	<center>
	<h3>재고변경</h3><hr>
		상품코드<input type="text" name="code"><br>
		재&nbsp;고&nbsp;량&nbsp;<input type="text" name="cnt"><br>
		<input type="radio" name="type" value="1" checked>추가
		<input type="radio" name="type" value="2">제거<br>
		<input type="submit" value="변경" onclick="return check()">
		<input type="button" value="돌아가기" onclick="location.href='<%=application.getContextPath()%>/main/main.jsp'">
		</center>
	</form>
</body>
</html>