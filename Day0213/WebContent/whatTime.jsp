<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<br>
	
	<c:if test="${date.hours<12}">오전입니다</c:if>
	<c:if test="${date.hours>=12}">오후입니다</c:if>
	<br>
	
	<c:choose>
		<c:when test="${date.hours >=9 && date.hours<12}">오전시간</c:when>
		<c:when test="${date.hours >=12 && date.hours<13}">점심시간</c:when>
		<c:when test="${date.hours >=13 && date.hours<18}">오후시간</c:when>
		<c:otherwise>자습시간</c:otherwise>
	</c:choose>
</body>
</html>