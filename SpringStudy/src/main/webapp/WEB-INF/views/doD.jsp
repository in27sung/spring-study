<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doD</title>
</head>
<body>
	<h1>hello, doD</h1>
	
	<h1> 전달정보 출력하기(MemberVO vo)</h1>
<%-- 	${requestScope} --%>
	<h2>userpw: ${memberVO}</h2>
	<h2>msg: ${msg}</h2>
	
	<hr>
	<h1> 전달된 DB정보 출력</h1>
	<h2>DB(vo): ${vo}</h2>
	<h2>DB(memberVO): ${memberVO}</h2>

	<hr>
	<h1> 전달된 DB정보 와 파라미터정보 출력</h1>
	<h2>parameter(pvo): ${pvo}</h2>
	<h2>DB(memberVO): ${memberVO}</h2>
	<hr>
	
</body>
</html>