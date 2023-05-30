<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 활동 내역</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.navbar {
	background-color: #f8f8f8;
}

.navbar-default .navbar-nav>li>a {
	color: #333;
}

.navbar-default .navbar-nav>li>a:hover, .navbar-default .navbar-nav>li>a:focus
	{
	background-color: #e7e7e7;
}

.navbar-default .navbar-nav>.active>a, .navbar-default .navbar-nav>.active>a:hover,
	.navbar-default .navbar-nav>.active>a:focus {
	background-color: #ddd;
	color: #333;
}

li {
	font-size: 16px;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
}

.card {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4); /* 수정된 부분 */
	text-align: center;
	font-family: Arial, sans-serif;
	font-size: 16px;
	color: #333333;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	padding: 10px;
	border-bottom: 1px solid #dddddd;
}

td {
	text-align: center;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="/hotel"> <img
					src="<spring:url value="/resources/hotelImg/main.png"/>">
				</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="myReservation">내 예약 목록</a></li>
				<li><a href="myWanted">내 찜 목록</a></li>
				<li><a href="myActivity">내 활동 내역</a></li>
				<li><a href="update">내 정보 수정</a></li>
				<li><a href="delete">회원 탈퇴</a></li>
				<li><a href="logout">로그아웃</a></li>
			</ul>
		</div>
	</nav>
	<h1 style="text-align : center;">내 활동 내역</h1><br>
	<div class="container">
		<div class="card">
			<table>
				<tr>
					<td>내 아이디</td>
					<td>${sessionScope.memberId}</td>
				</tr>
				<tr>
					<td>가입일</td>
					<td><fmt:formatDate value="${activity.memberDateCreated}"
							pattern="yyyy-MM-dd HH:mm:ss" var="memberDateCreated" />${memberDateCreated}</td>
				</tr>
				<tr>
					<td>내 게시글 수</td>
					<td>${activity.boardCnt} 개</td>
				</tr>
				<tr>
					<td>내 댓글 수</td>
					<td>${activity.replyCnt} 개</td>
				</tr>
				<tr>
					<td>내 리뷰 수</td>
					<td>${activity.reviewCnt} 개</td>
				</tr>
				<tr>
					<td>내가 찜한 호텔 수</td>
					<td>${activity.heartCnt} 개</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>