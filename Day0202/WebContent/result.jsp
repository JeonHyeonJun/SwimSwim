<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>너의이름은</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String one = request.getParameter("one");
		String two = request.getParameter("two");
		int a = Integer.parseInt(one);
		int b = Integer.parseInt(two);
		 
		if(name != null)
			out.println("당신의 이름은 "+name+"이군염<br/>");
		else
			out.println("이름없음<br/>");
		out.println("두 수의 합은 "+(a+b)+"입니다");
	%>
	<input type="button" value="개명하기" onclick="history.go(-1)"><!-- 뒤로가기버튼 -->
</body>
</html>