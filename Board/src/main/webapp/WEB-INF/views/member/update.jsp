<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
</head>
<body>
	<h2>내 정보 수정</h2>
	<form action="update" method="POST">
		<div>
			<input type="text" id="memberId" name="memberId" readonly value="${sessionScope.memberId}">
			<span id="message"></span>
		</div>
		<div>
			<input type="password" id="memberPw" name="memberPw" required>
		</div>
		<div>
			<input type="text" id="memberName" name="memberName" value="${vo.memberId}" required>
		</div>
		<div>
			<input type="text" id="memberPhone" name="memberPhone" value="${vo.memberPhone }" required>
		</div>
		<div>
			<input type="text" id="memberEmail" name="memberEmail" value="${vo.memberEmail }" required>
		</div>
		<div>
			<input type="submit" value="수정하기">
		</div>
	</form>
	
</body>
</html>