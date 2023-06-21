<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좋아요 목록</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
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

.board-list {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	margin-top: 30px;
	max-width: 1000px;
	margin-left: auto;
	margin-right: auto;
}

.board-item {
	width: calc(33.33% - 20px);
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 10px;
	text-align: center;
}

.board-item a {
	text-decoration: none;
}

.board-item img {
	width: 80%;
	height: 200px;
	object-fit: cover;
	border-radius: 5px;
}

.board-item h3 {
	margin-top: 10px;
	font-size: 20px;
}

.board-item p {
	margin: 5px 0;
	color: #888;
}

.board-item .heart-icon {
	color: red;
}

.board-item .detail-link {
	display: inline-block;
	margin-top: 10px;
	padding: 5px 10px;
	background-color: #2d9cdb;
	color: white;
	text-decoration: none;
	border-radius: 3px;
	transition: background-color 0.3s ease;
}

.board-item .detail-link:hover {
	background-color: #1b7aae;
}

h1 {
	text-align: center;
}

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
</style>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/board/board/list">게시판</a>
				<li><a href="myWanted">내 좋아요 목록</a></li>
				<li><a href="update">내 정보 수정</a></li>
				<li><a href="delete">회원 탈퇴</a></li>
				<li><a href="logout">로그아웃</a></li>
			</ul>
		</div>
	</nav>

	<h1>좋아요 목록</h1>
	<div class="board-list">
		<c:forEach var="vo" items="${list}" varStatus="status">
			<div class="board-item">
				<a href="../detail?boardId=${vo.boardId}"> 
				</a>
				<h3>${vo.boardTitle}</h3>
				<p>${vo.boardContent }</p>
				<p>${vo.replyCnt}개의 댓글</p>
				<p>
					<span id="heart" class="animated-heart">&#x2764;</span>
					(${vo.heartCnt})
				</p>
				<!--href에서 = ../detail?boardId는 안나오는데 /board/board/detail?은 나오는 이유 확인 -->
				<a class="detail-link" href="/board/board/detail?boardId=${vo.boardId}">자세히
					보기</a>
			</div>
			<c:if test="${status.count % 3 == 0 && !status.last}">
	</div>
	<div class="board-list">
		</c:if>
		</c:forEach>
	</div>

</body>
</html>