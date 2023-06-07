<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>호텔 로그인</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
<style>
body {
	background-color: #eee;
	margin-top: 30px;
}

.login-form {
	margin-top: 100px;
	margin-bottom: 100px;
	padding: 50px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
}

.login-form h1 {
	font-size: 36px;
	font-weight: bold;
	margin-bottom: 50px;
	text-align: center;
}

.login-form input[type=text], .login-form input[type=password] {
	border: none;
	border-radius: 0px;
	border-bottom: 1px solid #ccc;
	padding: 20px 0px;
	background-color: transparent;
	color: #666;
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 50px;
}

.login-form input[type=text]:focus, .login-form input[type=password]:focus
	{
	outline: none;
	border-bottom: 1px solid #007bff;
	color: #007bff;
}

.login-form input[type=submit] {
	display: block;
	width: 100%;
	border: none;
	border-radius: 50px;
	padding: 20px 0px;
	background-color: #007bff;
	color: #fff;
	font-size: 20px;
	font-weight: bold;
	transition: all 0.3s ease-in-out;
}

.login-form input[type=submit]:hover {
	background-color: #0056b3;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="d-flex justify-content-center">
		<a href="/hotel"> <img
			src="<spring:url value="/resources/hotelImg/main.png"/>" alt="호텔 로고">
		</a>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form class="login-form" action="login" method="POST">
					<h1 class="text-center">로그인</h1>
					<div class="form-group">
						<input type="text" class="form-control" name="memberId"
							placeholder="아이디" required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="memberPw"
							placeholder="비밀번호" required>
					</div>
					<button type="submit" class="btn btn-primary btn-lg btn-block">로그인</button>
				</form>
			</div>
		</div>
	</div>
	<div class="d-flex justify-content-center mt-2">
		<a href="/hotel/member/find-memberid" class="btn btn-link">아이디 찾기</a>
		<a href="/hotel/member/find-memberpw" class="btn btn-link">비밀번호 찾기</a>
	</div>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>

	<input type="hidden" id="alert" value="${result }">
	<script type="text/javascript">
		var result = $('#alert').val();
		if (result == 'loginFail') {
			alert('아이디 또는 비밀번호가 일치하지 않습니다!');
		} else if (result == 'notLogin') {
			alert('글 작성을 하려면 로그인 해주세요!');
		}
	</script>
</body>
</html>