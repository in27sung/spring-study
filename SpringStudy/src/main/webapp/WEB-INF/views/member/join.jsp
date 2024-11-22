<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create Account</title>
<link href="${path}/resources/css/join.css" rel="stylesheet"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<h1>Create account (Spring)</h1>
		<form action="" method="post">
			<div class="form-group">
				<label for="id"><b>ID</b></label> <input type="text" id="id"
					name="userid" required autofocus>
			</div>
			<div class="form-group">
				<label for="password"><b>Password</b></label> <input type="password"
					id="password" name="userpw" required>
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
					id="email" name="useremail" required>
			</div>
			<input type="submit" value="회원가입">
		</form>
	</div>
</body>
</html>