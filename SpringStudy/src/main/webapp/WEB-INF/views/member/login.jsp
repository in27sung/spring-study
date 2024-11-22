<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-with, initial-scale=1.0">
<title>Sign in</title>
<link href="${path}/resources/css/loginStyle.css" rel="stylesheet" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 스크립트 이용해서 로그인 실패 만들기 -->

	<div class="container">
		<h1>Sign in</h1>
		<%
			//session JSP 내장객체 
			//session.setAttribute(name, value)
		%>
		<form action="" method="post">
			<div class="form-group">
				<label for="userid">User name</label> 
				<input type="text" id="username" name="userid" autocomplete="off" required autofocus>
				<label for="password">Password</label> 
				<input type="password" name="userpw">
			</div>
			<input type="submit" value="로그인">
		</form>
		<div class="footer">
			<p>
				New to my page? <a href="join">Create account</a>
			</p>
		</div>
	</div>
</body>
</html>