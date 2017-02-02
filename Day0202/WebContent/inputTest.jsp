<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>다양한 입력 폼</title>
</head>
<body>
	<h3>다양한 입력 폼</h3>
	<form method="get" action="inputTest_result.jsp">
		성명: <input type="text" name="person" /> <br> 성별: <input
			type="radio" name="sex" value="male" />남성 <input type="radio"
			name="sex" value="female" />여성<br> 직업: <select name="job"
			size="1">
			<option>학생</option>
			<option>회사원</option>
			<option>공무원</option>
			<option>기타</option>
		</select>
		<p>
			구입희망분야(복수선택 가능)<br> - 분야: <input type="checkbox" name="books"
				value="computer" />컴퓨터 <input type="checkbox" name="books"
				value="economy" />경제 <input type="checkbox" name="books"
				value="common" />상식<br> 비고: <br>
			<textarea name="comments" rows="4" cols="40" /></textarea>
		</p>
		<hr>
		<input type="submit" value="신청" /> <input type="reset" value="취소" />
	</form>
</body>
</html>