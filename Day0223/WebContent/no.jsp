<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pink</title>
<script type="text/javascript">
	setTimeout(function() {
		location.href="test.jsp";
	}, 1000)
</script>
</head>
<body>
	<center><a href="result.jsp"><img src="img/exit.jpg"></a><br>
	<a href="test.jsp">돌아간다</a><br>
			<button onclick="history.back()">뒤로</button>
			<button onclick="history.forward()">앞으로</button>
	</center>
</body>
</html>