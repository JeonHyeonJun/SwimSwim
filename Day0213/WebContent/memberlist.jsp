<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>맴버전체조회</title>
</head>
<body>
<table border="1" style="width:100%; text-align:center;">
	<tr>
		<th> index</th> <th> count </th> <th> member </th>
	</tr>
		<c:forEach var="member" items="${list}" varStatus="status">
	<tr>
		<td> ${status.index} </td>
		<td> ${status.count} </td>
		<td>${member.name}</td>
	</tr>
		</c:forEach>
</table>
</body>
</html>