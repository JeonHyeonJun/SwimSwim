<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품검색</title>
<script type="text/javascript">
	function check() {
		if (isNaN(document.frm.cnt.value)) {
			alert("재고량은 숫자로 입력하세요!");
			document.frm.cnt.focus();
			return false;
		}
		else if(document.frm.cnt.value.length >10){
			alert("재고량은 10자리 이하 숫자만 검색 가능합니다.");
			document.frm.cnt.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="../select" method="get" name="frm">
		<center>
			<h3>상품검색</h3>
			<hr>
			상품코드<input type="text" name="code"><br>
			상&nbsp;품&nbsp;명&nbsp;<input type="text" name="name"><br>
			재&nbsp;고&nbsp;량&nbsp;<input type="text" name="cnt"><br>
			<input type="radio" name="type" value="1" checked>이상
			<input type="radio" name="type" value="2">이하<br>
			검색유형
			<select name="select" size="1">
				<option value="1">상품코드</option>
				<option value="2">상품명</option>
				<option value="3">재고량</option>
				</select><br>
			<input type="submit" value="검색" onclick="return check()"> <input
				type="button" value="돌아가기"
				onclick="location.href='<%=application.getContextPath()%>/main/main.jsp'">
		</center>
	</form>
</body>
</html>