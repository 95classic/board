<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.container {
	margin: 0 auto;
	max-width: 500px;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	text-align: center;
}

.logo {
	display: block;
	margin: 0 auto 20px;
	max-width: 200px;
}

h2 {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 20px;
	color: #444;
}

form {
	text-align: left;
}

label {
	display: block;
	font-size: 16px;
	font-weight: bold;
	margin-bottom: 5px;
	color: #555;
}

input[type="text"], input[type="password"] {
	display: block;
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	margin-bottom: 20px;
	font-size: 16px;
	color: #555;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4CAF50;
	border: none;
	color: #fff;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #3e8e41;
}
</style>
</head>
<body>
	<div class="container">
		<a href="/hotel"><img
			src="<spring:url value="/resources/hotelImg/main.png"/>"></a>
		<h2>회원가입</h2>
		<form action="register" method="POST">
			<div>
				<label for="memberId">아이디</label> <input type="text" name="memberId"
					id="memberId" placeholder="아이디 입력" autofocus required> <span
					id="messageId"></span>
			</div>
			<div>
				<label for="memberPw">비밀번호</label> <input type="password"
					name="memberPw" id="memberPw" placeholder="비밀번호 입력" required>
				<span id="messagePw"></span>
			</div>
			<div>
				<label for="memberPwCk">비밀번호 확인</label> <input type="password"
					name="memberPwCk" id="memberPwCk" placeholder="비밀번호 입력확인" required>
				<span id="messagePwCk"></span>
			</div>
			<div>
				<label for="memberName">이름</label> <input type="text"
					name="memberName" placeholder="이름 입력" required>
			</div>
			<div>
				<label for="memberPhone">휴대폰 번호</label> <input type="text"
					name="memberPhone" id="memberPhone" placeholder="휴대폰 번호 입력"
					required> <span id="messagePhone"></span>
			</div>
			<div>
				<label for="memberEmail">이메일</label> <input type="text"
					name="memberEmail" placeholder="이메일 입력" required>
			</div>
			<input type="submit" value="회원가입">
		</form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#memberId").blur(function() {
				var memberId = $(this).val(); // 아이디 입력값 가져오기
				if (memberId != "") { // 아이디 입력했을때
					$.ajax({
						type : 'post',
						url : '/hotel/member/idCheck', // controller의 idcheck로 보냄
						data : {
							memberId : memberId
						},
						success : function(data) {

							if (data == 1) {// 중복된 아이디가 있을때
								$("#messageId").html("이미 사용중인 아이디입니다");
							} else { // 중복된 아이디 없을때
								$("#messageId").html("사용 가능한 아이디입니다.");
							}
						},
						error : function() {
							$("#messageId").html("서버에서 오류가 발생하였습니다.");
							//console.log(data);
						}
					}); // end ajax
				}
			}); // end memberId.blur()

			// 비밀번호 확인 이벤트
			$("#memberPwCk").blur(function() {
				var memberPwCk = $(this).val();
				var memberPw = $("#memberPw").val();
				if (memberPwCk == memberPw) {
					$("#messagePwCk").html("비밀번호가 일치합니다");

				} else {
					$("#messagePwCk").html("비밀번호가 일치하지 않습니다.");

				}
			}); // end memberPwCk.blur()

			// 정규 표현식
			$("#memberPwCk").blur(function() {
				var memberPw = $("#memberPw").val();
				var exp = /[a-z0-9]$/;
				if (!exp.test(memberPw)) {
					$("#messagePw").html("비밀번호는 영문과 숫자만 넣어주세요");
					$("#memberPw").focus();
				}
			}); // end memberPwCk.blur()

			// 휴대폰 번호 중복체크
			$("#memberPhone").blur(function() {
				var memberPhone = $(this).val(); // 휴대폰 번호 입력값 가져오기
				if (memberPhone != "") { // 휴대폰 번호 입력했을때
					$.ajax({
						type : 'post',
						url : '/hotel/member/phoneCheck', // controller의 phonecheck로 보냄
						data : {
							memberPhone : memberPhone
						},
						success : function(data) {


							if (data == 1) {// 중복된 휴대번호 있을때
								$("#messagePhone").html("이미 사용중인 휴대폰 번호입니다");
							} else { // 중복된 휴대번호 없을때
								$("#messagePhone").html("사용 가능한 휴대폰 번호입니다.");
							}
						},
						error : function() {
							$("#messagePhone").html("서버에서 오류가 발생하였습니다.");
							//console.log(data);
						}
					}); // end ajax
				}
			}); // end memberPhone.blur()

		}); // end document
	</script>
</body>
</html>