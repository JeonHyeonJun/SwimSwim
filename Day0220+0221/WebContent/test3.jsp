<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>함수 : 코드의 집합을 나타내는 자료형</title>
</head>
<body>
	자바스크립트에서 함수는 두가지가 있다.<br>
	선언함수와 익명함수<br>
	선언함수는 페이지가 로드될 때 모든 선언함수부터 읽어서 메모리에 올리고 다시 맨위부터 명령수행<br>
<script type="text/javascript">
		
//		func();	//선언함수는 생성전에 호출해도 됨

		//선언함수 만들기
		function func(){
			alert("이것은 선언함수YO!");
		}
		//선언함수 재정의
		function func(){
			alert("2것은 선언함수YO!");
		}
		
//		myfunc();	//익명함수는 생성전에 호출하면 에러
		
		//익명함수 만들기
		var myfunc = function (){
			alert("이것이 익명함수DA!!");
		};
		//익명함수 재정의
		myfunc = function (){
			alert("2것2 익명함수DA!!");
		};
		
		//함수 호출하기
//		func();
//		myfunc();
		
		//이렇게 호출하면 변수가 담고있는 코드가 출력된다
//		alert(func);
//		alert(myfunc);
	
		//사용자가 입력한 값 받기
//		var name = prompt("이름을 입력하세용");
//		alert("너의 리음은"+name+"입니다.");
		
		function f(x){
			alert(arguments.length);
			alert(arguments[3]);
			return x * x ;
		}
		
//		alert(f(3,1,2,5));	//이렇게 불러도 다 전달은 되나 싱행은 맨앞의 것만 x로 인식함.
							//고로 결과는 9
							
		function sumAll(){
			var sum = 0;
			for(var i=0; i<arguments.length; i++){
				sum += arguments[i];
			}
			return sum;
		}
//		alert(sumAll(3,5,7,9));
		
		function returnTest(){
			alert("ㅎ2욤");
			return;		//리턴했으니 여기서 끝남. 아무튼 끝남!
			alert("ㅂ2염");
		}
//		alert(returnTest());	
	
		
		//뭐가출력될까?
		function a(){
			alert("그냥 a입니다.");
		}
		function func1(){
			a();
			function a(){
				alert("1번의 a입니다.");
			}	
		}
		function func2(){
			function a(){
				alert("2번의 a입니다.");
			}
		}	
//		func1();
		
		//배열로 내보내기?
		function funcArray(x) {
			if(x instanceof Array ){
				for(var i in x)
					alert(x[i]);
			}
		}
//		funcArray(['Hong',2,true]);
		
		function callFiveTimes(func){
			for(var i=0; i<5; i++)
				func();
		}
		
		callFiveTimes(function(){
			alert("옜다");
		})
		
		var meFunc = function(){
			alert("옜다옛다");
		}
		
		callFiveTimes(meFunc);
</script>
</body>
</html>