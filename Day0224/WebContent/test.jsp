<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var sun = document.getElementById("sun");
		var earth = document.getElementById("earth");
		var moon = document.getElementById("moon");
		
		//문서객체 속성 조작하기
		sun.style.position = "absolute";
		earth.style.position = "absolute";
		moon.style.position = "absolute";
		
		sun.style.left = "450px";
		sun.style.top = "400px";
		
		var earthAngle = 0;
		var moonAngle = 0;
		setInterval(function() {
			var earthleft = 450 + 150 * Math.cos(earthAngle);
			var earthTop = 400 + 150 * Math.sin(earthAngle);
			earth.style.left = earthleft + "px";
			earth.style.top = earthTop + "px";
			
			earthAngle += 0.1;
			
			var moonleft = earthleft + 150 * Math.cos(moonAngle);
			var moonTop = earthTop + 150 * Math.sin(moonAngle);
			moon.style.left = moonleft + "px";
			moon.style.top = moonTop + "px";
			moonAngle += 0.1;
		}, 100)
	}
</script>
</head>
<body>
	<img id="sun" src="img/hos.gif" width="100px" height="100px">
	<img id="earth" src="img/bing.gif" width="100px" height="100px">
	<h1 id="moon">@</h1>
</body>
</html>