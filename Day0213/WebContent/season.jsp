<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	<%
		List<String> season = new ArrayList<String>();
		season.add("봄");
		season.add("여름");
		season.add("가을");
		season.add("겨울");
		request.setAttribute("list", season);
	%>
	<select name="season">
		<c:forEach var="list" items="${list}" varStatus="status">
			<option value="${list}">${list}
		</c:forEach>
	</select>
</body>
</html>