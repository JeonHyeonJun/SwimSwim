<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 삭제</title>
<script type="text/javascript">
	function check() {
		if(document.frm.code.value.length != 4){
			alert("상품코드는 4자리만 입력할 수 있습니다.");
			document.frm.code.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<center>
<h3>상품 삭제</h3><hr>
<form action="<%=application.getContextPath() %>/delete" name="frm">
상품 코드 : <input type="text" name="code"><br>
<input type="submit" value="확인" onclick="return check()">&nbsp;<input type="button" value="돌아가기" onclick="location.href='<%=application.getContextPath() %>/main/main.jsp'">
</form>
</center>
</body>
</html>