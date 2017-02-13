<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 배열</title>
</head>
<body>
	<%
		String[] movieList = {"0조","너의E름은","레지던트이불","바eo하자드"};
		pageContext.setAttribute("movieList", movieList);
	%>
	
	<c:forEach var="movies" items="${movieList}">
		${movies}<br>
	</c:forEach>
</body>
</html>