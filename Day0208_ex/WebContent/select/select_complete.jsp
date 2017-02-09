<%@page import="javax.swing.ListModel"%>
<%@page import="java.util.List"%>
<%@page import="model.Stock"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검색결과</title>
</head>
<body>
<center>
	<%
		Stock stock = (Stock)request.getAttribute("stock");
		List<Stock> list = (List)request.getAttribute("list");
	%>
	<h3>검색결과</h3><hr>
	<table border="1">
	<th>상품코드</th>
	<th>상품명</th>
	<th>수량</th>
	<%
		if(stock == null && list==null){
			
		}
		else if(list == null){
			%>
			<tr>
				<td><%= stock.getCode() %></td>
				<td><%= stock.getName() %></td>
				<td><%= stock.getCnt() %></td>
				</tr>
			<%
			
		}
		else if(stock == null){
			for(int i=0; i<list.size(); i++){
				%>
				<tr>
				<td><%= list.get(i).getCode() %></td>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getCnt() %></td>
				</tr>
				<% 
			}
		}
	%>
	</table>
	<input type="button" value="돌아가기" onclick="location.href='<%=application.getContextPath() %>/main/main.jsp'">
	</center>
</body>
</html>