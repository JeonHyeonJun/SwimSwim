<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����̸���</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String one = request.getParameter("one");
		String two = request.getParameter("two");
		int a = Integer.parseInt(one);
		int b = Integer.parseInt(two);
		 
		if(name != null)
			out.println("����� �̸��� "+name+"�̱���<br/>");
		else
			out.println("�̸�����<br/>");
		out.println("�� ���� ���� "+(a+b)+"�Դϴ�");
	%>
	<input type="button" value="�����ϱ�" onclick="history.go(-1)"><!-- �ڷΰ����ư -->
</body>
</html>