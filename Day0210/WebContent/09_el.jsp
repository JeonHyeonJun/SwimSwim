<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${member.name}<br>
	아이디 : ${member["userid"]}
	
	이름1 : ${list[0].name}<br>
	아이디1 : ${list[0].userid }<br>
	이름2 : ${list[1].name}<br>
	아이디2 : ${list[1].userid }<br>
	이름3 : ${list[2].name}<br>
	아이디3 : ${list[2].userid }<br>
	이름4 : ${list[3].name}<br>
	아이디4 : ${list[3].userid }<br>
	
</body>
</html>