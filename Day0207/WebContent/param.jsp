<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����</title>
<script type="text/javascript">
	function check() {
		if(document.frm.id.value == ""){
			alert("���̵� �Է������");
			document.frm.id.focus();
			return false;
		}
		else if(document.frm.age.value == ""){
			alert("������ �˷����");
			document.frm.age.focus();
			return false;
		}
		else if(isNaN(document.frm.age.value)){
			alert("���ھƴԤ�");
			document.frm.age.focus();
			return false;
		}
		else
			return true;
	}

</script>
</head>
<body>
	<form action="ParamServlet" method="post" name="frm">
		���̵� : <input type="text" name="id"/><br/>
		�� &nbsp; �� : <input type="text" name="age"/><br/>
		<input type="submit" value="����" onclick="return check()"/>
		<input type="submit" value="����" onclick="alert('You just activated my trap card!');return false;"/>
	</form>
</body>
</html>