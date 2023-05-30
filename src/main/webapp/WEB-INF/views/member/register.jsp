<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<body>
	<h2>회원가입</h2>
	<form action="register" method="POST">
	 	<div>
	 		<input type="text" name="memberId" id="memberId" placeholder="아이디입력"
	 		autofocus required> <span id="messageId"></span>
	 	</div>
	 	<div>
	 		<input type="password" name="memberPw" id="memberPw" placeholder="비밀번호 입력">
	 		<span id="messagePw"></span>
	 	</div>
	 	<div>
	 		<input type="password" name="memberPwCk" id="memberPwCk" placeholder="비밀번호 입력확인"
	 		required> <span id="messagePwCk"></span>
	 	</div>
	 	<div>
	 		<input type="text" name="memberName" placeholder="이름 입력" required>
	 	</div>
	 	<div>
	 		<input type="text" name="memberPhone" id="memberPhone"
	 		placeholder="휴대폰 번호 입력" required> <span id="meesagePhone"></span>
	 	</div>
	 	<div>
	 		<input type="text" name="memberEmail" placeholder="이메일 입력" required>
	 	</div>
	 	<input type="submit" value="회원가입">
	</form>
	
	<script type="text/javascript">
		$(document).ready(function(){
			// 아이디 중복체크
			$("#memberId").blur(function(){
				var memberId = $(this).val(); // 아이디 입력값 가져오기
				if (memberId != "") { // 아이디 입력했을때
					$.ajax({
						type : 'post'
						url : '/hotel/member/idCheck', // contorller의 idCheck로 보냄
						date : {
							memberId : memberId
						},
						success : function(date) {
							
							if(date == 1) { // 중복된 아이디가 있을때
								$("#messageId").html("이미 사용중인 아이디입니다");
							} else { // 중복된 아이디 없을때
								$("#messageId").html("사용 가능한 아이디입니다");
							}
						},
						error : function() {
							$("#messageId").html("서버에서 오류가 발생하였습니다");
							// console.log(data);
						}
					}); // end ajax
				} // end if(memberId != "")
			}); // end memberId .blur
			
			// 비밀번호 확인
			$("#memberPwCk").blur(function(){
				var memberPwCk = $(this).val();
				var memberPw = $("#memberPw").val();
				if (memberPwCk == memberPw) {
					$("#messagePwCk").html("비밀번호가 일치합니다");
				} else {
					$("#messagePwCk").html("비밀번호가 일치하지 않습니다.");
				}
			});// end memberPwCk.blur

			// 비밀번호 정규표현식
			$("#memberPwCk").blur(function(){
				var memeberPw = $('#memberPw').val();
				var exp = /[a-z0-9]$/;
				if (!exp.test(memberPw)) {
					$("#messagePw").html("비밀번호는 영문과 숫자만 넣어주세요");
					$("#memberPw").focus();
				}
			}); // end memberPwck.blur
		
			// 휴대폰 번호 중복체크
			$("#memberPhone").blur(function(){
				var memberPhone = $(this).val(); // 휴대폰 번호 입력값 가져오기
				if (memberPhone != "") { // 휴대폰 번호 입력했을때
					$.ajax({
						type : 'post',
						url : '/member/phoneCheck',
						date : {
							memberPhone : memberPhone
						},
						success : function(data) {
							if(date == 1) { // 중복된 휴대번호가 있을때
								$("#messagePhone").html("이미 사용중인 휴대폰 번호입니다");
							} else { // 중복된 휴대번호 없을때
								$("#messagePhone").html("사용 가능한 휴대폰 번호입니다.");
							}
						},
						error : function() {
							$("#messagePhone").html("서버에서 오류가 발생하였습니다.");
						}
					}); // ajax
				}
			
			});// memberPhone.blur
			
		}); // end document ready
	</script>
</body>
</html>