<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>분리하기</title>
</head>
<body>
<%
	String url = (String)request.getAttribute("url");
	if(url == null)
		url = "../hello/hello.jsp";
%>
	<table border="1" width="1024" height="768">
		<tr height="100">
			<td colspan="2"><jsp:include page="../module/header.jsp" flush="false"></jsp:include>
			</td>
		</tr>
		<tr height="300">
			<td align="left" width="100"><jsp:include page="../module/left.jsp"
					flush="false"></jsp:include></td>
			<td><jsp:include page="<%= url %>"
					flush="false"></jsp:include></td>
		</tr>
		<tr height="100">
			<td colspan="2"><jsp:include page="../module/footer.jsp" flush="false"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>