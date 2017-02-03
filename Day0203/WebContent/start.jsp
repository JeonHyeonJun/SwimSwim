<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>지겨운계산기시간</title>
</head>
<body>
	<form action="forwardTest.jsp">
		<input type="text" name="1"/><br>
		<input type="text" name="2"/><br>
		<select name="calculator" size="1">
			<option value="1">덧셈</option>
			<option value="2">뺄셈</option>
			<option value="3">곱셈</option>
		</select><br>
		 <input type="submit" value="계산" />
	</form>
</body>
</html>