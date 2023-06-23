<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style type="text/css">
@keyframes heartbeat {
  0% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.2);
  }
  100% {
    transform: scale(1);
  }
}
.animated-heart {
	animation: heartbeat 1s infinite;
	display: inline-block;
	color: red;
	font-size: 20px;
}

body {
	background-color: WhiteSmoke;
}

.navbar {
	background-color: #f8f9fa;
	border-bottom: 1px solid #dee2e6;
	margin-bottom: 20px;
}

.navbar-brand img {
	/* 이미지 크기 조정 부분 제거 */
	
}

.navbar-nav {
	display: flex;
	align-items: center;
	justify-content: flex-start; /* 수정된 부분 */
	margin-left: 10px; /* 수정된 부분 */
}

.navbar-nav .nav-link {
	color: #333;
	margin-right: 10px; /* 수정된 부분 */
}

.navbar-nav .nav-link:hover {
	color: #2d9cdb;
}

.hotel-information {
	text-align: center;
}

.pagination {
	margin: 30px auto;
	text-align: center;
}

.pagination ul {
	display: inline-block;
	margin: 0;
	padding: 0;
}

.pagination li {
	display: inline;
	margin: 0;
	padding: 0;
}

.pagination li a {
	color: #555;
	display: inline-block;
	padding: 5px 10px;
	text-decoration: none;
}

.pagination li a.active {
	background-color: #555;
	color: #fff;
}

.hotel-wrapper {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin: 0 auto;
	max-width: 960px;
	padding: 20px;
}

.hotel {
	background-color: #f2f2f2;
	border-radius: 10px;
	box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
	margin-bottom: 20px;
	overflow: hidden;
	width: 30%;
}

.hotel img {
	display: block;
	height: 200px;
	object-fit: cover;
	width: 100%;
}

.hotel h3 {
	color: #444444;
	font-family: 'Open Sans', sans-serif;
	font-size: 20px;
	margin: 20px;
	text-align: center;
}

.hotel p {
	color: #888888;
	font-family: 'Open Sans', sans-serif;
	font-size: 16px;
	margin: 0 20px 10px;
	text-align: center;
}

.hotel a {
	border: none;
	border-radius: 5px;
	color: #ffffff;
	display: block;
	font-family: 'Open Sans', sans-serif;
	font-size: 16px;
	margin: 0 auto 20px;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	width: 80%;
}

.hotel a:hover {
	cursor: pointer;
}

.pagination {
	display: flex;
	justify-content: center;
	margin-top: 30px;
}

.pagination ul {
	display: flex;
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.pagination li {
	margin: 0 10px;
}

.pagination li a {
	color: #2d9cdb;
	font-family: 'Open Sans', sans-serif;
	font-size: 16px;
	text-decoration: none;
}

.pagination li.active a {
	font-weight: bold;
}

.pagination li a:hover {
	text-decoration: underline;
}

.hotel-information {
	text-align: center;
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light">
		<a class="navbar-brand" href="/hotel"><img
			src="<spring:url value="/resources/hotelImg/main.png"/>"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mr-auto">
				<!-- 수정된 부분 -->
				<c:if test="${not empty sessionScope.memberId }">
					<li class="nav-item"><a class="nav-link">${sessionScope.memberId }님,
							반갑습니다!</a></li>
					<li class="nav-item"><a class="nav-link" href="member/logout">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link" href="member/mypage">마이페이지</a></li>
				</c:if>
				<c:if test="${empty sessionScope.memberId }">
					<li class="nav-item"><a class="nav-link" href="login">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						href="member/register">회원가입</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="board/list">게시판</a></li>
			</ul>
		</div>
	</nav>

	<h1 class="hotel-information">호텔 정보</h1>
	<div class="d-flex justify-content-center mb-3">
		<div class="btn-group" role="group" aria-label="정렬">
			<a href="/hotel" class="btn btn-outline-primary">등록순</a> <a
				href="?sortBy=hotelName" class="btn btn-outline-primary">이름순</a> <a
				href="?sortBy=hotelReviewCnt" class="btn btn-outline-primary">리뷰순</a>
			<a href="?sortBy=hotelReviewAvg" class="btn btn-outline-primary">별점순</a>
		</div>
	</div>

	<form action="?keyword=${keyword}" method="GET" class="form-inline justify-content-center">
		<div class="form-group">
			<label for="keyword" class="mr-2" style="font-size: 18px;">호텔명
				검색 :</label> <input type="text" id="keyword" name="keyword"
				class="form-control mr-2" style="width: 300px;" required>
			<button type="submit" class="btn btn-primary">검색</button>
		</div>
	</form>

	<div class="hotel-wrapper">
		<c:forEach var="vo" items="${list}">
			<div class="hotel">
				<a
					href="detail?hotelId=${vo.hotelId}&amp;page=${pageMaker.criteria.page}">
					<img src="<spring:url value='${vo.hotelImg}'/>">
				</a>
				<h3>${vo.hotelName }</h3>
				<p>${vo.reviewCnt }개의리뷰</p>
				<p>별점 평균 (${vo.hotelReviewAvg }/5)</p>
				<p>
					<span id="heart" class="animated-heart">&#x2764;</span>
					(${vo.heartCnt})
				</p>
				<a style="background-color: #2d9cdb;"
					href="detail?hotelId=${vo.hotelId}&amp;page=${pageMaker.criteria.page}">자세히
					보기</a>
			</div>
		</c:forEach>
	</div>

	<div class="pagination">
		<ul>
			<c:if test="${pageMaker.hasPrev }">
				<li><a href="?page=${pageMaker.startPageNo - 1 }">이전</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }" var="num">
				<li>
					<a href="?page=${num }&sortBy=${sortBy }">${num }</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.hasNext }">
				<li><a href="?page=${pageMaker.endPageNo + 1 }">다음</a></li>
			</c:if>
		</ul>
	</div>

	<input type="hidden" id="alert" value="${result }">
	<script type="text/javascript">
		var result = $('#alert').val();
		if (result == 'registerSuccess') {
			alert('회원가입 완료!');
		} else if (result == 'deleteSuccess') {
			alert('회원탈퇴 완료!');
		} else if (result == 'loginSuccess') {
			alert('로그인 완료!');
		} else if (result == 'logoutSuccess') {
			alert('로그아웃 완료!');
		} else if (result == 'searchFail') {
			alert('검색결과가 없습니다!');
		}
	</script>

</body>
</html>