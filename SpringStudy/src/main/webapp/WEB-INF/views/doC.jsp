<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doC</title>
</head>
<body>
	<h1>hello, doC</h1>
	
	<h1> 전달정보 출력하기</h1>
	<h2 style="color: red">msg: <%=request.getParameter("msg")%></h2>
	<h2 style="color: red">msg(el): ${param.msg}</h2>
	
	<hr>
	
	<h1>@ModelAttribute("msg") String msg 사용 후</h1>
	<h2>1) 전달하는 파라메터값 저장</h2>
	<h2>2) 전달 받은 데이터를 request영역에 저장</h2>
	
	<h2 style="color: red">msg(el): ${msg}</h2>
	<h2 style="color: red">msg(el): ${requestScope.msg}</h2>
	
<%-- 	<h2>msg(el): ${영역객체.msg}</h2> --%>

	<hr>
	
	
	<h2 style="color: red">msg(el): ${id}</h2>
	<h2 style="color: red">msg(el): ${requestScope.pw}</h2>
</body>
</html>