<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>빙글빙글</title>
<script type="text/javascript">
	//일정시간 경과후 실행하기
//	setTimeout(function() {
//		alert("3초가 지났넹ㅋ");
//		location.href="http://naver.com";
//	}, 3000);//3초
	
	//일정시간 간격으로 계속 실행하기
/*  	var id = setInterval(function(){
		alert("잠깐휴식");
	},5000);//5초
	//setInterval을 멈추게 하는것!
	setTimeout(function(){
		clearInterval(id);
		location.href="result.jsp";
	},25000); */
	
	//실헝
/* 	alert('a');

	setTimeout(function() {
		alert('b');
	}, 0);	//0초지만 일단 다른명령 다 수행한 후 0초후에 수행
			//그러므로 결과는 a c b
	alert('c'); */
	
	//?
/* 	var output="";
	for(var key in window){
		output += key + '//' + window[key] + '\n';
	}
	alert(output); */
	
	//새로운 window를 열기
	/* var d = window.open("result.jsp", "prog" , "width=300, height=300", true);//링크, 이름(안써도됨), 크기조정 
	
	
	
	var one = setInterval(function() {
		d.moveTo((Math.random()*1000), (Math.random()*1000));
	}, 100);
	
	setTimeout(function() {
		e = window.open("result.jsp", "prog2" , "width=300, height=300", true);//링크, 이름(안써도됨), 크기조정 
		two = setInterval(function() {
			e.moveTo((Math.random()*1000), (Math.random()*1000));
		}, 100);
	}, 5000)
	
	setTimeout(function() {
		clearInterval(one);
		clearInterval(two)
		d.close();
		e.close();
	}, 30000); */
	

</script>
</head>
<body>
<a href="result.jsp"><img src="img/bing.gif"></a><img src="img/bing.gif"><br>
	<center>
			<a href="no.jsp">여기서 나간다</a><br>
			<button onclick="history.back()">뒤로</button>
			<button onclick="history.forward()">앞으로</button>
	</center>
	<img src="img/bing.gif"><img src="img/bing.gif">
</body>
</html>