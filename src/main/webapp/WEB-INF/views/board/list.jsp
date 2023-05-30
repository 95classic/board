<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<meta charset="UTF-8">
<title>게시판 메인 페이지</title>
<style>
body {
	background-color: #f8f9fa;
	color: #212529;
}

.container {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h1 {
	margin-top: 0;
	margin-bottom: 20px;
	font-size: 28px;
	font-weight: bold;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
	color: #fff;
}

.btn-primary:hover {
	background-color: #0069d9;
	border-color: #0062cc;
	color: #fff;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	padding: 10px;
	border: 1px solid #dee2e6;
}

th {
	font-weight: bold;
}

.text-dark {
	color: #343a40;
}

.pagination {
	justify-content: center;
	margin-bottom: 20px;
}

.page-item:not(:last-child) {
	margin-right: 5px;
}

.custom-select {
	width: 150px;
	margin-right: 10px;
}

.form-control {
	flex: 1;
}

.my-4 {
	margin-top: 40px;
	margin-bottom: 40px;
}

#alert {
	display: none;
}
</style>
</head>
<body>
  <div class="contaniner">
	<h1>게시판 메인</h1>
	
	
  <div>
  		<c:if test="${not empty sessionScope.memberId }">
					<a>${sessionScope.memberId }님,반갑습니다!</a>
					<a  href="/board/member/logout">로그아웃</a>
					<a  href="/board/member/mypage">마이페이지</a>
		</c:if>
		<c:if test="${empty sessionScope.memberId }">
					<a href="/board/member/login">로그인</a>
					<a href="/board/member/register">회원가입</a>
		</c:if>
		
  </div>
	
	
	<a href="register"><button type="button">글 작성</button></a>
	
	<hr>
	<table>
		<thead>
			<tr>
				<th style="width : 120px">작성자</th>
				<th style="width : 500px">제목</th>
				<th style="width : 130px">작성일</th>
				<th style="width : 60px">댓글수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.memberId }</td>
				<td><a href="detail?boardId=${vo.boardId }&page=${pageMaker.criteria.page }"
					   class="text-dark">${vo.boardTitle }</a></td>
				<fmt:formatDate value="${vo.boardDateCreated }"
				pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
				<td>${boardDateCreated }</td>
				<td>${vo.replyCnt }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<ul>
		<c:if test="${pageMaker.hasPrev }">
			<li><a href="list?page=${pageMaker.startPageNo -1 }">이전</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }"
			var="num">
			<li><a href="list?page=${num }">${num }</a></li>
		</c:forEach>
		<c:if test="${pageMaker.hasNext }">
			<li><a href="list?page=${pageMaker.endPageNo + 1 }">다음</a></li>
		</c:if>
		
	</ul>
	
	<!-- BaordController -> registerPOST()에서 보낸 데이터 저장 -->
	<input type="hidden" id="Alert" value="${result }">
  </div>
  
  
	<script type="text/javascript">
		var result = $('#Alert').val();
		if(result == 'success') {
			alert('새 게시글 글 작성 성공!');
		} else if(result == 'updateSuccess') {
			alert('게시글 수정 성공')
		} else if(result == 'deleteSuccess') {
			alert('게시글 삭제 성공')
		}
	</script>
	
</body>
</html>
 









