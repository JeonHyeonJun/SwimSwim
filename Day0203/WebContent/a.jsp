<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a</title>
</head>
<body>
	Hello, I am Ari;
	<%
		System.out.println("나 a.jsp는 b.jsp와 배다른형제였던 것이다!!");
		String name = "Hong";
//		String param = request.getParameter("name");
//		System.out.println(param);	
	%>
	<jsp:forward page="b.jsp">
		<jsp:param value="<%=name %>" name="name"/>
	</jsp:forward>







</body>
</html>