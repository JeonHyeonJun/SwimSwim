<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL로 현재시간 표현</title>
</head>
<body>
	현재 시간은 ${date.hours}입니다.
	<br>
	기존방식은 <%=request.getAttribute("date") %>
</body>
</html>