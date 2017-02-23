<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java스크립트로 html코드 넣기</title>
<script type="text/javascript">
	window.onload = function(){
		var header = document.createElement("h1");	//요소노드생성
		var textNode = document.createTextNode("제목");	//텍스트노드생성
		header.appendChild(textNode);	//header(h1)요소에 textNode(제목)를 연결
		document.body.appendChild(header);
		
		var img = document.createElement("img");
		//1번방법
//		img.src = "img/bing.gif";
//		img.width = 1200;
//		img.height = 768;
		//2번방법(이걸로 하는것을 권장!)
		img.setAttribute('src', 'img/bing.gif');
		img.setAttribute('width', 500);
		img.setAttribute('height', 300);
		//img.data-property => 이방식으로 값을 못주는 속성
		img.setAttribute('data-property', 350);
		
		document.body.appendChild(img); 

		//글머리기호
		/* var output = '';
		output +=  '<ul>';
		output +=  '<li>123</li>';
		output +=  '<li>456</li>';
		output +=  '<li>789</li>';
		output +=  '</ul>';
		document.body.innerHTML = output; */
		
		
		//문서객체 가져오기
		/* var header1 = document.getElementById("header1");
		var header2 = document.getElementById("header2");
		header1.innerHTML = "대가리1";
		header2.innerHTML = "대가리2";
		
		//문서객체 가져오기(tag이름으로)
		var headers = document.getElementsByTagName("h1");
		for( var i =0; i<headers.length; i++){
			headers[i].innerHTML = "개굴개굴"+i;
		}  */
		
		var input = document.getElementById("input_button3");
		input.onclick = function(){
			alert("바보");
		};
		
		var input2 = document.getElementById("input_button4");
		var ipt = document.getElementById("input_text");
		input2.onclick = function(){
			alert(ipt.value);
		};
	}
	
	
	function result(){
		alert("바보");
	}
	
	
</script>
</head>
<body>
	<h1 id='header1'>머리1</h1>
	<h1 id='header2'>머리2</h1>
	<input type="text" id="input_text">
	<input type="button" value="나가기1" id="input_button1" onclick="alert('바보')">
	<input type="button" value="나가기2" id="input_button2" onclick="result()">
	<input type="button" value="나가기3" id="input_button3">
	<input type="button" value="출력" id="input_button4">
</body>
</html>