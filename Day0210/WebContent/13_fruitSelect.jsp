<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.fruit == 1}">
			<span style="color: red;">Bad Apple!</span>
		</c:when>
		<c:when test="${param.fruit == 2}">
			<span style="color: green;">메롱>ㅠ<</span>
		</c:when>
		<c:when test="${param.fruit == 3}">
			<span style="color: purple;">바나나먹으면나한테바나나?</span>
		</c:when>
	</c:choose>
</body>
</html>