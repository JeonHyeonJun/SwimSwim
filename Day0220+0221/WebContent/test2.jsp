<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var input = Number(prompt('숫자를 입력하세요.', '숫자'));
 
	switch(input % 2) {
    case 0:
        alert("짝수입니다.");
        break;
    case 1:
        alert("홀수입니다.");
        break;
    default:
        alert("숫자가 아닙니다.");
        break;
}
	
	value = 0;
	while(value < 5) {
	    alert(value + '번째 반복');
	    value++;
	}
	
	true || alert('실행될까요?A');
	false || alert('실행될까요?B');
	// A는 실행되지 않고 B는 실행된다.
	 
	true && alert('실행될까요?C');
	false && alert('실행될까요?D');
	// C는 실행되고 D는 실행되지 않는다.
</script>
</head>
<body>
	꺄륵
</body>
</html>