<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var btn1 = document.getElementById('btn1');
		var btn2 = document.getElementById('btn2');
		
		btn1.onclick = function(){
			counter1.innerHTML = Number(counter1.innerHTML) +1;
		}
		btn2.onclick = function(){
			counter2.innerHTML = Number(counter2.innerHTML) +1;
		}
		btn3.onclick = function(){
			counter1.innerHTML = Number(counter1.innerHTML) + Math.round((Math.random()*2)-1);
			counter2.innerHTML = Number(counter2.innerHTML) + Math.round((Math.random()*2)-1);
		}
	}
</script>
</head>
<body>
	<button id='btn1'>버튼하나</button>
	<button id='btn2'>버튼둘</button>
	<button id='btn3'>버튼삼</button>
	<h1>버튼하나counter : <span id='counter1'>0</span></h1>
	<h1>버튼둘counter : <span id='counter2'>0</span></h1>
</body>
</html>