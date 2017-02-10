<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신이가 입력한 정보입니다.(고전)	<hr>
	아이디 : <%=request.getParameter("id") %><br>
	비밀번호 : <%=request.getParameter("pwd") %><br>
	==연산자 사용결과 : <%=request.getParameter("id") == "pinkgay" %><br><br>
	
	당신이가 입력한 정보입니다. (세련(EL))<hr>
	아이디 : ${param.id }<br> 
	비밀번호 : ${param["pwd"] }<br>
	==연산자 사용결과 : ${param.id =="pinkgay"}
	
</body>
</html>