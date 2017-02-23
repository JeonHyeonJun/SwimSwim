<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
/* 	alert(screen.width);	//화면의 너비
	alert(screen.height);	//화면의 높이
	alert(screen.availWidth);	//실제화면에서 사용가능한 너비
	alert(screen.availHeight);	//실제화면에서 사용가능한 높이
	alert(screen.pixelDepth);	//한 픽셀당 비트수
	alert(screen.colorDepth);	//사용가능한 색상 수 */
	
	//화면이 점점 줄어든다!
/* 	var child = window.open("result.jsp", "prog" , "width=300,height=300");
	var width = screen.width;
	var height = screen.height;
	child.moveTo(0,0);
	child.resizeTo(width, height);
	
	var id = setInterval(function() {
		child.resizeBy(-20,-20);
		child.moveBy(10,10);
	}, 1000);
	setTimeout(function() {
		clearInterval(id);
		child.close();
	}, 10000); */
	
	window.onload = function(){
//		alert("onload함수는 화면이 다 열린 후에 수행되는 메소드");
		var hell = document.getElementById('bing');
		var bye = document.getElementById('digital');
		hell.onclick = function(){
			hell.style.background = 'red';
		};
		bye.onclick = function(){
			bye.style.background = 'blue';
		}
	}
</script>
<body>
	<center>
		<img src="img/bing.gif">
		<img src="img/digital.GIF">
	</center>
	<h1 id = 'bing'>빙글빙글</h1>
	<h1 id = 'digital'>끄덕끄덕</h1>
</body>
</html>