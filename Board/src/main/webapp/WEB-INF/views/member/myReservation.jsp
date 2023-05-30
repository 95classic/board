<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 예약 목록</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-color: #f2f2f2;
}

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

table {
	font-family: Arial, sans-serif;
	color: #333;
}

th {
	font-weight: bold;
}

td, th {
	border: 1px solid #ddd;
	padding: 0.5rem;
}

button[type=submit] {
	cursor: pointer;
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

	<h1 style="margin-bottom: 30px; text-align: center;">${sessionScope.memberId }님의
		예약 목록</h1>

	<div style="max-width: 800px; margin: 0 auto;">
		<c:forEach var="vo" items="${list }">
			<div
				style="border: 1px solid #ddd; padding: 2.6rem; margin-bottom: 1.5rem; background-color: #f2f2f2;">
				<div
					style="display: flex; align-items: center; justify-content: space-between; margin-bottom: 1.5rem;">
					<h3 style="margin: 0; font-size: 2.5rem; color: #333;">
						<a href="../detail?hotelId=${vo.hotelId}"
							style="text-decoration: none; color: #333;"
							onmouseover="this.style.color='#ffcc00';"
							onmouseout="this.style.color='#333';">
							${vo.reservationHotelName} </a>
					</h3>
					<span style="font-size: 1.5rem; color: #777;">총 숙박료:
						${vo.totalPrice }원</span>
				</div>
				<div
					style="display: flex; align-items: flex-start; justify-content: space-between;">
					<div>
						<p style="margin: 0; font-size: 1.7rem;">객실 종류 :
							${vo.reservationRoomName }</p>
						<p style="margin: 0; font-size: 1.7rem;">
							체크인 날짜:
							<fmt:formatDate value="${vo.reservationCheckIn }"
								pattern="yyyy-MM-dd (E)" />
						</p>
						<p style="margin: 0; font-size: 1.7rem;">
							체크아웃 날짜:
							<fmt:formatDate value="${vo.reservationCheckOut }"
								pattern="yyyy-MM-dd (E)" />
						</p>
					</div>
					<form action="cancleReservation" method="POST">
						<input type="hidden" name="reservationId"
							value="${vo.reservationId}"> <input type="hidden"
							name="roomId" value="${vo.roomId}">
						<button type="submit"
							style="background-color: #ff6961; color: #fff; border: none; padding: 0.8rem 1.5rem; border-radius: 5px; font-size: 1.2rem;">예약취소</button>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>

	<input type="hidden" id="alert" value="${result }">

	<script type="text/javascript">
		var result = $('#alert').val();
		if (result == 'createSuccess') {
			alert('예약 성공!');
		} else if (result == 'deleteSuccess') {
			alert('예약 취소 완료!');
		}
	</script>

</body>
</html>