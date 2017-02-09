<%@page import="model.Stock"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<Stock> list = (List<Stock>)request.getAttribute("list");
%>
<center>
<h3>상품 전체 검색</h3><hr>
<img src="<%= application.getContextPath()%>/img/good.jpg" onclick="location.href='<%=application.getContextPath()%>/main/main.jsp'">
<table border="1">
<tr>
<th>코드</th>
<th>상품명</th>
<th>수량</th>
<th>삭제</th>
</tr>
<%
	for(int i=0; i<list.size(); i++) {
%>
<tr>
<td><%=list.get(i).getCode()%></td>
<td><%=list.get(i).getName()%></td>
<td><%=list.get(i).getCnt()%></td>
<td><input type="button" value="삭제" onclick="location.href='<%=application.getContextPath() %>/delete?type=<%=list.get(i).getCode() %>'"></td>
</tr>
<% 
	}
%>
</table>
<input type="button" value="돌아가기" onclick="location.href='<%=application.getContextPath() %>/main/main.jsp'">
</center>
</body>
</html>