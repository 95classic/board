<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>호텔 로그인</title>
</head>
	<div>
		<form action="login" method="POST">
			<h1>로그인</h1>
			<div>
				<input type="text" name="memberId" placeholder="아이디" required>
			</div>
			<div>
				<input type="password" name="memberPw" placeholder="비밀번호" required>
			</div>
			<button type="submit">로그인</button>
		</form>
	</div>
	<div>
		<a href="/member/find-memberid">아이디 찾기</a>
		<a href="/member/find-memberpw">비밀번호 찾기</a>
	</div>
</body>
</html>