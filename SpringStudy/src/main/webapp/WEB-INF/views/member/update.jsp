<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Account</title>
<link href="${path}/resources/css/join.css" rel="stylesheet"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<h1>Update account (Spring)</h1>
<%-- 		${resultVO} --%>
		<form action="" method="post">
			<div class="form-group">
				<label for="id"><b>ID</b></label> <input type="text" id="id"
					name="userid" value="${resultVO.userid}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="password"><b>Password</b></label> <input type="password"
					id="password" name="userpass" required autofocus>
			</div>
			<div class="form-group">
				<label for="name"><b>Name</b></label> <input type="text" id="name"
					name="username" required>
			</div>
			<!--             <div class="form-group"> -->
			<!--                 <label for="age"><b>Age</b></label> -->
			<!--                 <input type="number" id="age" name="age" required> -->
			<!--             </div> -->
			<!--             <fieldset class="form-group"> -->
			<!--                 <legend><b>Gender</b></legend> -->
			<!--                 <label><input type="radio" name="gender" value="male" required> Male</label> -->
			<!--                 <label><input type="radio" name="gender" value="female" required> Female</label> -->
			<!--             </fieldset> -->
			<div class="form-group">
				<label for="email"><b>E-mail</b></label> <input type="email"
					id="email" name="useremail" value="${resultVO.useremail}" readonly="readonly">
			</div>
			<input type="submit" value="정보수정">
		</form>
	</div>
</body>
</html>