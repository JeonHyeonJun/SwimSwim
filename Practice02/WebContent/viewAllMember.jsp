<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 맴버 조회</title>
</head>
<body>
	<center>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
			<%
					List<Member> list = (List) request.getAttribute("list");
					for (int i = 0; i < list.size(); i++) {
				%>
			<tr>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getName()%></td>
			</tr>
			<%
					}
				%>
		</table>
		<input type="button" value="메인으로" onclick="location.href='start.jsp'">
	</center>
</body>
</html>