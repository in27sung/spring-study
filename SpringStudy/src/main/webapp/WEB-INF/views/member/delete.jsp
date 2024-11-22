<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-with, initial-scale=1.0">
<title>Delete Account</title>
<link href="${path}/resources/css/loginStyle.css" rel="stylesheet" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 스크립트 이용해서 회원삭제 만들기 -->
	<div class="container">
		<h1>Delete Account</h1>
		<script type="text/javascript">
// 		var result = "${result}";
		
			if(${result} == 0){				
				alert("비밀번호가 일치하지 않습니다.")
			}
		</script> 
		
		<form action="" method="post">
			<div class="form-group">
<!-- 				<label for="userid">User name</label>  -->
				<input type="hidden" id="username" name="userid" value="${sessionScope.userid}" required readonly="readonly">
<%-- 				<input type="text" id="username" name="userid" value="${sessionScope.userid}" required readonly="readonly"> --%>
				<label for="password">Password</label> 
				<input type="password" name="userpw">
			</div>
			<input type="submit" value="회원탈퇴">
		</form>
		<div class="footer">
		</div>
	</div>
</body>
</html>