<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var header = document.getElementById('header');
		header.onclick = function(e){
			alert(this);
			this.style.color = 'Orange';
			this.style.backgroundColor = 'Pink';
			alert(e.x +',' + e.y);
			//한번 클릭하면 다시 클릭해도 안나옴!
			header.onclick = null;
		}
	}
</script>
</head>
<body>
	<h1 id='header'>잡아봐라</h1>
</body>
</html>