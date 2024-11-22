<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Account Info</title>
<link href="${path}/resources/css/mainStyle.css" rel="stylesheet"
	rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
	<header>
			
	<h1>회원정보 조회</h1>
	</header>
<%-- 	${resultVO} --%>
	<nav>
	 <ul>
		 <li><a class="nav-link" href="main">메인 페이지</a></li>
	 </ul>
	</nav>
	<hr>
	
	
	<h4>아이디: ${resultVO.userid}</h4>
	<h4>비밀번호: ${resultVO.userpw}</h4>
	<h4>이름: ${resultVO.username}</h4>
	<h4>이메일: ${resultVO.useremail}</h4>
	<h4>가입일: ${resultVO.regdate}</h4>
	
	<hr>

	</div>
</body>
</html>