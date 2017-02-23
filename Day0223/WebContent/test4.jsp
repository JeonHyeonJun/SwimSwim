<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var div1 = document.getElementById("div1");
		var div2 = document.getElementById("div2");
		setTimeout(function(){
			div1.style.background = 'red';
			div1.style.color = 'gray';
		},1000);
		setTimeout(function(){
			div2.style.background = 'blue';
			div2.style.color = 'white';
		},2000);
		
		setTimeout(function() {
			alert("밤이 다가왔습니다.");
			document.body.removeChild(div2);
			alert("파란휴지가 죽었습니다.");
		}, 5000);
	}	
</script>
</head>
<body>
	<div id='div1'><h1>빨간휴지</h1></div><br>
	<div id='div2'><h1>파란휴지</h1></div>
</body>
</html>