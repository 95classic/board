<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
  background-color: #f2f2f2;
}

.navbar {
  background-color: #f8f8f8;
}

.navbar-default .navbar-nav > li > a {
  color: #333;
}

.navbar-default .navbar-nav > li > a:hover,
.navbar-default .navbar-nav > li > a:focus {
  background-color: #e7e7e7;
}

.navbar-default .navbar-nav > .active > a,
.navbar-default .navbar-nav > .active > a:hover,
.navbar-default .navbar-nav > .active > a:focus {
  background-color: #ddd;
  color: #333;
}

.page-content {
  padding: 20px;
}
li {
	font-size : 16px;
}
</style>
</head>
<body>
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">

      </div>
      <ul class="nav navbar-nav">
		<li><a href="/board/board/list">게시판</a></li>
        <li><a href="myWanted">내 좋아요 목록</a></li>
        <li><a href="update">내 정보 수정</a></li>
        <li><a href="delete">회원 탈퇴</a></li>
        <li><a href="logout">로그아웃</a></li>
      </ul>
    </div>
  </nav>

  <div class="page-content">
    <input type="hidden" id="alert" value="${result }">
    <script type="text/javascript">
      var result = $('#alert').val();
      if (result == 'updateSuccess') {
        alert('내 정보 수정 완료!');
      }
    </script>
  </div>
</body>
</html>