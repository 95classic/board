<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>

<!-- jQuery 추가 -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
<body>

		<h1 >회원 탈퇴</h1>
		<form  action="delete"method="POST">
			<div >
				<input type="text"  name="memberId"
					value="${sessionScope.memberId }" readonly>
			</div>
			<div>
				<input type="password" name="memberPw"  required>
			</div>
			<button type="submit" >탈퇴하기</button>
		</form>
	

	<input type="hidden" id="alert" value="${result }">

	<script type="text/javascript">
		var result = $('#alert').val();
		if (result == 'deleteFail') {
			alert('아이디와 비밀번호가 일치하지 않습니다!');
		}
	</script>

	
</body>
</html>