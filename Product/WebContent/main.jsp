<%@page import="model.Stock"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function edit(btn){
	if(btn.value == "수정"){
		var code = btn.getAttribute("name");
		var ename = document.getElementById("2_"+code);
		var ecnt = document.getElementById("3_"+code);
		btn.value= "확인";
		ename.removeAttribute("readonly");
		ecnt.removeAttribute("readonly");
	}
	else{
		var code = btn.getAttribute("name");
		btn.value = "수정";
		var ename = document.getElementById("2_"+code);
		var ecnt = document.getElementById("3_"+code);
		ename.setAttribute("readonly", true);
		ecnt.setAttribute("readonly", true);
		var http = new XMLHttpRequest();
		http.open('get','update.do?code='+code+'&name='+ename.value+'&cnt='+ecnt.value);
		http.onreadystatechange = function(){
			if(http.readyState == 4 && http.status == 200){
				alert("수정");
			}
		}
		http.send();
	}

}

function remove(btn){
	var code = btn.getAttribute("name");
	var result = document.getElementById(code);
	result.parentNode.removeChild(result);
	
	var http = new XMLHttpRequest();
	http.open('get','delete.do?code='+code);
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
		}
	}
	http.send();
}

window.onload = function(){
	var code = document.getElementById("code");
	
	code.addEventListener("blur", function() {
		var http = new XMLHttpRequest();
		http.open('get','codeCheck.do?code='+code.value);
		http.onreadystatechange = function(){
			if(http.readyState == 4 && http.status == 200){
				var json = JSON.parse(http.responseText);
				if(json.result)
					alert("ㅇㅇㄴㅇ");
				else
					alert("ㅈㅂ");
			}
		}
		http.send();
	});
	
	var index = document.getElementById("index");
	var rowsCount = index.rows.length-2;

}
</script>
</head>
<body>
	
			<form action="create.do" method="post">
	<table border="1" width="1024" id="index">
		<tr height="5">
			<th>상품코드</th><th>상품명</th><th>수량</th>
		</tr>
		<tr height="5" align="center">
		<td><input type="text" name="code" id="code" placeholder="상품코드를 입력하세여"></td>
		<td><input type="text" name="name" id="name" placeholder="상품명을 입력하세여"></td>
		<td><input type="text" name="cnt" id="cnt" placeholder="수량을 입력하세여"></td>
		<td width="10"><input type="submit" value="추가" id="input"></td>
		</tr>
		
		
		<c:forEach var="list" items="${list}">
		<tr align="center" id="${list.code}">
		<td><input type="text" readonly="readonly" value="${list.code}" id="1_${list.code}"></td>
		<td><input type="text" readonly="readonly" value="${list.name}" id="2_${list.code}"></td>
		<td id=><input type="text" readonly="readonly" value="${list.cnt}" id="3_${list.code}"></td>
		<td width="10"><input type="button" value="수정" id="${list.code}" name="${list.code}" onclick="edit(this)"></td>
		<td width="10"><input type="button" value="삭제" id="${list.code}" name="${list.code}" onclick="remove(this)"></td>
		</tr>
		</c:forEach>
		
	</table>
		</form>
	
</body>
</html>