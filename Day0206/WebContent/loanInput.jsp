<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>형 또왔다</title>
</head>
<body>
	<h3>돈갚으셔야죠^^</h3>
	<form action="<%=application.getContextPath() %>/loanProc.do">
	대출금 <input type="text" name="money"><br>
	대출금리 <input type="text" name="gmri"><br>
	상환개월수 <input type="text" name="month"><br>
	대출유형  <input type="radio" name="select" value="onerigm">원리금균등상환
	<input type="radio" name="select" value="onegm">원금균등상환<br>
	<input type="submit" value="계산">
	<input type="reset" value="안해">
	</form>
</body>
</html>