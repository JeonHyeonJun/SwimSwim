<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//보조함수들 자주사용되는 기능들 선언함수로 등록
//랜덤한 정수를 생성하는 함수
	function number(limit){
		return Math.round(Math.random()*limit);
	}
	
//랜덤한 알파벳을 선택하는 함수
	var abcd = 'ABCDEFHIJKLMNOPQRSTUWXYZ';
	function randomabc(){
		return abcd.charAt(number(25));
	}
	
//랜덤한 속도를 생성하는 함수
	function speed(speed){
		return Math.round(Math.random()*speed) - Math.round(Math.random()*speed);
	}
</script>
<script type="text/javascript">
//하나의 움직이는 문자인 MovingText의 생성자 함수
	var MAX_X = 700;
	var MAX_Y = 500;
	function MovingText(){
		this.x = number(MAX_X);
		this.y = number(MAX_Y);
		this.vX = speed(30);
		this.vY = speed(30);
		this.body = document.createElement('h1');
		this.body.innerHTML = randomabc();
		this.body.style.position = 'absolute';
		
		document.body.appendChild(this.body);
	}
	
	MovingText.prototype.move = function(){
		if(this.x < 0 || this.x > MAX_X){this.vX *= -1}
		if(this.y < 0 || this.x > MAX_Y){this.vY *= -1}
		this.x += this.vX;
		this.y += this.vY;
		this.body.style.left = this.x +'px';
		this.body.style.top = this.y + 'px';
	}
</script>
<script type="text/javascript">
//window.onload 함수
window.onload = function(){
	var movingTexts = [];
	for( var i = 0; i<100; i++)
		movingTexts.push(new MovingText());
	
	setInterval(function() {
		for(var i in movingTexts)
			movingTexts[i].move();
	}, 100);
}
//MovingText객체를 적당한 갯수로 만들어서
//setInterval함수에서 각 문자들을 이동시킴
</script>

<script type="text/javascript">
//샘플
/* window.onload = function(){
	var MAX_X = 700;
	var MAX_Y = 500;
	var sample = document.getElementById("a");
	sample.style.position = "absolute";
	var x = Math.round(Math.random()*MAX_X);
	var y = Math.round(Math.random()*MAX_Y);
	sample.style.left = x + "px";
	sample.style.top = y + "px";
	
	setInterval(function() {
		var ranX = Math.round(Math.random()*20)-10;
		var ranY = Math.round(Math.random()*20)-10;
		
		if(x < 0 || x > MAX_X){
			ranX *= -1; 
		}
		if(y < 0 || y > MAX_Y){
			ranY *= -1;
		}
		x += ranX;
		y += ranY;
		sample.style.left = x + 'px';
		sample.style.top = y +'px';
	}, 100)
} */
</script>
</head>
<body>
</body>
</html>