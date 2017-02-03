<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전달자</title>
</head>
<body>
	<%
		String calculator = request.getParameter("calculator");
		int a = Integer.parseInt(request.getParameter("1"));
		int b = Integer.parseInt(request.getParameter("2"));
		int result = 0;
		String url ="";
	if(calculator.equals("1")){
		result = a+b;
		url = "add.jsp";
	} else if(calculator.equals("2")){
		result = a-b;
		url = "subtract.jsp";
	} else if(calculator.equals("3")){
		result = a*b;
		url = "mult.jsp";
	}
	%>
	<jsp:forward page="<%=url%>">
		<jsp:param value="<%=result %>" name="result"/>
	</jsp:forward>
</body>
</html>