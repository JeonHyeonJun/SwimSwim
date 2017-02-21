<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>연습문제</title>
</head>
<body>
<script type="text/javascript">
	function add(){
		var num1 = Number(prompt("첫번째 숫자를 입력하세용"));
		var num2 = Number(prompt("두번째 숫자를 입력하세용"));
		var result = num1+num2;
		return result;
	}
	
	function mul(x,y){
		var num1 = prompt("첫번째 숫자를 입력하세용");
		var num2 = prompt("두번째 숫자를 입력하세용");
		var result = Number(num1)*Number(num2);
		return result;
	}
	
	function replace(func){
		alert("대신 출력해드립니다!!");
		var result = func;
		alert(result);
	}
	alert(add());
	alert(mul());
	replace(add());
</script>
</body>
</html>