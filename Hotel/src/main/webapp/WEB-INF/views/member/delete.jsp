<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<!-- 부트스트랩 CSS 추가 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
<!-- jQuery 추가 -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
<body>
<a href="/hotel"><img src="<spring:url value="/resources/hotelImg/main.png"/>"></a>
	<div class="container my-5">
		<h1 class="text-center mb-4">회원 탈퇴</h1>
		<form class="mx-auto" style="max-width: 400px;" action="delete"
			method="POST">
			<div class="form-group">
				<label for="memberId">아이디</label> <input type="text"
					class="form-control" name="memberId"
					value="${sessionScope.memberId }" readonly>
			</div>
			<div class="form-group">
				<label for="memberPw">비밀번호</label> <input type="password"
					class="form-control" name="memberPw" required>
			</div>
			<button type="submit" class="btn btn-danger btn-lg btn-block my-4">탈퇴하기</button>
		</form>
	</div>

	<input type="hidden" id="alert" value="${result }">

	<script type="text/javascript">
		var result = $('#alert').val();
		if (result == 'deleteFail') {
			alert('아이디와 비밀번호가 일치하지 않습니다!');
		}
	</script>

	
	<!-- 부트스트랩 JS 추가 -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>