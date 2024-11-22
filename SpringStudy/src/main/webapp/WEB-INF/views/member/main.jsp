<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link href="${path}/resources/css/mainStyle.css" rel="stylesheet"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<header>
			<h1>Welcome to Main Page</h1>
			<c:if test="${empty sessionScope.userid}">
				<input type="button" class="btn-logout" value="로그인"
					onclick="location.href='login';">
			</c:if>
			<c:if test="${!empty sessionScope.userid}">
			<input type="button" class="btn-logout" value="로그아웃"
				onclick="location.href='logout';">
			</c:if>
		</header>

		<main>
			<!-- el 표현식 사용 -->
			<!-- 사용자가 로그인을 성공했을 때만 페이지를 확인 가능 -->
			<!-- 로그인 정보가 없을 때 로그인 페이지로 이동 -->
			<!-- 로그인 정보가 있을 때 'ooo님 환영합니다!' 출력 -->

			<h2 id="welcome-msg">${sessionScope.userid}님 환영합니다!</h2>
			<script type="text/javascript">
				var result = "${result}"; // -> "userid"
// 				var userid = admin;
				
// 				if(${empty userid}){
// 					alert("로그인 페이지로 이동합니다")
// 					// 로그인 페이지로 이동하는 기능 구현
// 				}else			
				if(${!empty result}){
					alert("${userid}님 환영합니다")
				}
				
			</script>
			<!-- <div id="main-actions">  -->
			<!-- <input type="button" class="btn" value="Logout" onclick="location.href='./MemberLogout.me';">  -->
			<!-- </div>  -->
			<hr>

			<nav>
				<ul>
					<li><a class="nav-link" href="info">회원정보 조회</a></li>
					<li><a class="nav-link" href="update">회원정보 수정</a></li>
					<li><a class="nav-link" href="delete">회원정보 삭제</a></li>
					<li><a class="nav-link" href="boardWrite">게시판 글쓰기</a></li>
					<li><a class="nav-link" href="boardList">게시판 리스트</a></li>
				</ul>
			</nav>

			<hr>
			<!-- sessionScope. 생략가능 -->
			<!-- id.contains('admin') 아이디에 'admin' 값이 포함되면 true 없으면 false -->
<%-- 			<c:if test="${!empty sessionScope.userid && userid.equals('admin')}"> --%>
			<c:if test="${!empty userid && userid.contains('admin')}">
				<!-- 관리자 전용 메뉴 -->
				<h3>Admin Menu</h3>
				<nav>
					<ul>
						<li><a class="nav-link" href="list">회원정보 목록</a></li>
					</ul>
				</nav>
			</c:if>
		</main>
	</div>
</body>
</html>