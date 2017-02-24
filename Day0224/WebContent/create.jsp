<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var checkTest = /^[A-Z]{3}[0-9]{5}$/;	//대문자3글자 후 숫자5글자 넣어야 됨
		var phoneNumberTest = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/;	//폰번호
		var check = /(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@\#$%^&*\()\-=+_'])(?=.{8,})/;
		
		var checkD = /(?=.*[A-Z])/;
		var checkS = /[a-z]/;
		var checkT = /[~!@\#$%^&*\()\-=+_']/;
		//대문자,소문자,숫자,특수문자,8글자이상의 조건!
		
//		alert(checkTest.test("AAA33333"));
//		alert(phoneNumberTest.test("010-9999-9999"));
//		alert(check.test("AA0!1234a"));
		pass2.oninput  = function(){
			var pass2 = document.getElementById('pass2');
			
			if(pass2.value.length >= 8)
				eight2.innerHTML = '';
			else
				eight2.innerHTML = '8자이상,';
			
			if(checkD.test(pass2.value)){
				d2.innerHTML = '';
			}
			else
				d2.innerHTML = '대문자,';
			
			if(checkS.test(pass2.value)){
				s2.innerHTML = '';
			}
			else
				s2.innerHTML = '소문자,';
			
			
			if(checkT.test(pass2.value)){
				t2.innerHTML = '';
			}
			else
				t2.innerHTML = '특수문자';
			
			if(check.test(pass2.value)){
				all2.innerHTML = '굳굳';
			}
			else
				all2.innerHTML = '추가해주셈';
		}
		
		setInterval(function() {
			var pass = document.getElementById('pass');
			
			
			if(pass.value.length >= 8)
				eight.innerHTML = '';
			else
				eight.innerHTML = '8자이상,';
			
			if(checkD.test(pass.value)){
				d.innerHTML = '';
			}
			else
				d.innerHTML = '대문자,';
			
			if(checkS.test(pass.value)){
				s.innerHTML = '';
			}
			else
				s.innerHTML = '소문자,';
			
			
			if(checkT.test(pass.value)){
				t.innerHTML = '';
			}
			else
				t.innerHTML = '특수문자';
			
			if(check.test(pass.value)){
				all.innerHTML = '굳굳';
			}
			else
				all.innerHTML = '추가해주셈';
			
			}, 100)
			
	}
	
	
	
	
	
	
	
	
</script>
</head>
<body>
<center>
	<h1>회원 가입</h1><br>
	아이디 : <input type="text" name="id"><input type="button" value="중복확인" onclick="alert('빈칸만 아니면됨')"><br>
	비밀번호 : <input type="password" name="pass" id="pass">
	<span style="color: red" id='eight'>8자이상,</span>
	<span style="color: red" id='d'>대문자,</span>
	<span style="color: red" id='s'>소문자,</span>
	<span style="color: red" id='t'>특수문자</span>
	<span id="all">추가해주셈</span><br>
	비밀번호확인 : <input type="password" name="pass2" id="pass2">
	<span style="color: red" id='eight2'>8자이상,</span>
	<span style="color: red" id='d2'>대문자,</span>
	<span style="color: red" id='s2'>소문자,</span>
	<span style="color: red" id='t2'>특수문자</span>
	<span id="all2">추가해주셈</span><br>
	닉네임 : <input type="text" name="name"><br><br>
<h1>
☆공허의유산☆♚♚히어로즈 오브 더 스<br>
☆톰♚♚<input type="button" value="가입" onclick="location.href='http://kr.battle.net/heroes/ko/'">시$$전원 카드팩☜☜뒷면<br>
100%증정※ ♜월드오브 워크래프트♜<br>
펫 무료증정￥ 특정조건 §§디아블로3§<br>
§★공허의 유산★초상화획득기회@@@ <br>
</h1>
<img src="img/hos.gif">
</center>
</body>
	
</html>