<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		var name = document.getElementById("name");
		var id = document.getElementById("id");
		//		var pass = document.getElementById("pass");
		//		var pass2 = document.getElementById("pass2");

		pass2.oninput = function() {
			var pass = document.getElementById("pass");
			var pass2 = document.getElementById("pass2");

			if (pass.value == pass2.value && pass.value != "") {
				pass2check.innerHTML = "일치";
			}
			else
				pass2check.innerHTML = "불일치";
		}

		ok.addEventListener('click', function() {
			if(name.value == "")
				alert("닉네임을 입력해주세여");
			else if(id.value =="")
				alert("아이디를 입력해주세여");
			else if(pass.value =="")
				alert("비밀번호 입력해주세여");
			else if(pass2check.innerHTML == "일치") {
				var req = new XMLHttpRequest();
				req.open("post", "login.do");
				req.onreadystatechange = function() {
					if (req.readyState == 4 && req.status == 200) {
						var results = JSON.parse(req.responseText);
						alert(results.result.msg);
					}
				};
				req.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
				req.send("name=" + name.value + "&id=" + id.value + "&pass=" + pass.value);
			}	
			else{
				alert("비밀번호가 일치하지 않습니다.");
			}
		});

	};
</script>
</head>
<body>
	<form >
	<table align="center">
	<tr><td align="center">닉네임</td><td><input type="text" name="name" id="name" placeholder="닉네임을 입력하세요"><span id="namecheck"></span></td></tr>
	<tr><td align="center">아이디</td><td><input type="text" name="id" id="id" placeholder="아이디를 입력하세요"><span id="idcheck"></span></td></tr>
	<tr><td align="center">비밀번호</td><td><input type="password" name="pass" id="pass"><span id="passcheck"></span></td></tr>
	<tr><td align="center">비밀번호확인</td><td><input type="password" name="pass2" id="pass2"><span id="pass2check"></span></td></tr>
	</table>
	<center>
	<input type="button" value="확인" id="ok">
	<input type="reset" value="취소">
	</center>
	</form>
</body>
</html>