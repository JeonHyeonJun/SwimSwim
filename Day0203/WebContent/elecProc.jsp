<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>누진세계산</title>
</head>
<body>
	<%
	int use = Integer.parseInt(request.getParameter("elec"));
	final double[] plus = { 60.7, 125.9, 187.9, 280.6, 417.7, 709.5 };
	final int[] start = { 410, 910, 1600, 3850, 7300, 12940 };
	
	int i= 0;
	double result = 0;
	
	while(true){
		if(use > 100 && i<5){
			result += plus[i] * 100;
			i++;
			use -= 100;
		}
		else{
			result += plus[i] * use +plus[i];
			break;
		}
	}
	%>
	<jsp:forward page="elecResult.jsp">
	<jsp:param value="<%=result %>" name="result"/>
	</jsp:forward>
</body>
</html>