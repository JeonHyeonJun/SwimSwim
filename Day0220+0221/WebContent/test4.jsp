<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	//내부함수
/* 	function func(){
		alert("func호출");
		var a = function(){
			alert("func의 내부 함수");
		}
		return a;
	}
//	var result = func();
//	result();
	
	function func2(){
		alert("func2호출");
		return function hou(){
			alert("func2의 내부함수 호출");
		}
	}
//	func2()();	//func2를 실행하고 반환값을 또 실행. hou()라고 보면됨. */

	//클로저 : 내부함수가 외부함수의 맥락에 접근할 수 있는 것
	/* var myFunc = function(){
		var hello = 'Hell!';
		var inner = function(){
			alert(hello);
		};
		return inner;
	};
	
	var a = myFunc();
	var b = myFunc();
	a();	//반환값으로 사용한 내부함수에서 그 지역변수를 사용하고 있어서 해제되지 못하고 남아있는 현상
	b();	//이를 클로저라 함.
 */
 
 	/* var sequencer = function (){
		var s = 0;
		return function(){
			return ++s;
		}
	}	

	var seq1 = sequencer();
	var seq2 = sequencer();
	seq1();
	seq1();
	alert(seq1());		//3
	alert(seq2());		//1 */
	
	var arr = [];
	for(var i=0; i<3; i++){
		
		(function(){
			var idx = i;
			arr[idx] = function(){
				alert(idx);
			}
		})();
//		 arr[i] = function(){
//			alert(i);
//		} 
//		arr[i]();
	}
	
	arr[0]();
	arr[1]();
	arr[2]();
</script>
	<center>아조씨랑 비밀친구 할래요?<br>
	<img src="img/secret.png"><br>
	<a href="yes.jsp">응.할래!</a>&nbsp;
	<a href="no.jsp">응.안해^^</a>
	</center>
</body>
</html>