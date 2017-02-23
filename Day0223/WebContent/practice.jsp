<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var pass = document.getElementById("pass");
		var pass2 = document.getElementById("pass2");
		var check = document.getElementById("check");
		
		check.onclick = function(){
			if(pass.value==pass2.value){
				alert("같음");
			}
			else 
				alert("다름");
		};
	}
</script>
</head>
<body>
	비번<input type="password" id="pass"><br>
	확인<input type="password" id="pass2">
	<input type="button" value="체크" id="check">
</body>
</html>