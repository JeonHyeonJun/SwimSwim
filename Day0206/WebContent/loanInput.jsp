<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� �ǿԴ�</title>
</head>
<body>
	<h3>�������ž���^^</h3>
	<form action="<%=application.getContextPath() %>/loanProc.do">
	����� <input type="text" name="money"><br>
	����ݸ� <input type="text" name="gmri"><br>
	��ȯ������ <input type="text" name="month"><br>
	��������  <input type="radio" name="select" value="onerigm">�����ݱյ��ȯ
	<input type="radio" name="select" value="onegm">���ݱյ��ȯ<br>
	<input type="submit" value="���">
	<input type="reset" value="����">
	</form>
</body>
</html>