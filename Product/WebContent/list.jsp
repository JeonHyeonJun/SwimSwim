<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	var btn1 = document.getElementById("btn1");
	var btn2 = document.getElementById("btn2");
	
	btn1.addEventListener("click", function() {
		btn1.value = "확인";
	});
}
</script>
</head>
<body>

	<table border="1" align="center" width="1024">
		<tr><th>상품코드</th><th>상품명</th><th>수량</th></tr>
		<c:forEach var="list" items="${list}">
		<tr align="center">
		<td>${list.code}</td>
		<td>${list.name}</td>
		<td>${list.cnt}</td>
		<td width="10"><input type="button" value="수정" id="btn1"></td>
		<td width="10"><input type="button" value="삭제" id="btn2"></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>