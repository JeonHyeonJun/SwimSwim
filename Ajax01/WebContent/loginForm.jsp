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
window.onload = function(){
	<%
		MemberDao md = MemberDao.getInstance();
		List<Member> list = md.selectAll();
	%>
	name.oninput = function(){
		var name = document.getElementById("name");
		namecheck.innerHTML= "입력중";
		if(name == "야야")
			namecheck.innerHTML= "입력중dd";
		 for(var i=0; i<list.size; i++){
			var result = list.get(i).getName;
			if(result != null)
				namecheck.innerHTML = "중복된 닉네임 입니다.";
		} 
	};
}
</script>
</head>
<body>
	<form action="login.do" method="post">
	닉네임 <input type="text" name="name" id="name"><span id="namecheck"></span><br>
	아이디<input type="text" name="id" id="id"><span id="idcheck"></span><br>
	비밀번호<input type="password" name="pass" id="pass"><span id="passcheck"></span><br>
	비밀번호확인<input type="password" name="pass2" id="pass2"><span id="pass2check"></span><br>
	<input type="submit" value="확인">
	<input type="button" value="취소">
	</form>
</body>
</html>