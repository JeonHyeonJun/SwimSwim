<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품재고관리</title>
</head>
<body>
<center>
<h3>상품재고관리</h3><hr>
<table border="1">
<tr>
<td rowspan="5"><img src="<%= application.getContextPath()%>/img/main.jpeg" onclick="location.href='<%=application.getContextPath() %>/session'"></td>
	<td align="center"><a href="<%=application.getContextPath() %>/create/create_input.jsp">상품 등록</pre></a></td></tr>
	<tr>
	<td align="center"><a href="<%=application.getContextPath() %>/update/update_input.jsp">재고 수량 변경</a></td></tr>
	<td align="center"><a href="<%=application.getContextPath() %>/select/select_input.jsp">상품 검색</a></td></tr>
	<td align="center"><a href="<%=application.getContextPath() %>/selectall">상품 목록</a></td></tr>
	<td align="center"><a href="<%=application.getContextPath() %>/delete/delete_input.jsp">상품 제거</a></td></tr>
	</table>
</center>
</body>
</html>