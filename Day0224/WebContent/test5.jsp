<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		/* document.getElementById('main').onclick = function(){
			alert('main현타');
		};
		document.getElementById('header').onclick = function(e){
			alert('header현타');
//			e.cancelBubble = true;	//익스플로러전용
			if(e.stopPropagation){
				e.stopPropagation();	//그 외 브라우저(이게 더 중요)
			}
		} */
		
		var header = document.getElementById('header');
		var handler = function(e){
			alert('이벤트 처리함수 여러개 걸어줄수 있음');
			header.removeEventListener('click',handler); //이벤트 제거
		};
		header.addEventListener('click',handler);
	}
</script>

</head>
<body>
	<div id='main' style="background-color: pink;">
	<br>
		<img id='header' src="img/bing.gif" style="background-color: yellow;">
	<br>
	</div>
</body>
</html>