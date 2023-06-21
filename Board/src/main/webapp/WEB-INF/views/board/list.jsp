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
					<a  href="/board/hotel/list">여행사</a>
		</c:if>
		<c:if test="${empty sessionScope.memberId }">
					<a href="/board/member/login">로그인</a>
					<a href="/board/member/register">회원가입</a>
					<a href="/board/hotel/list">여행사</a>
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
				<th style="width : 50px">좋아요</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
		<!-- 여기서 var="vo"는 list가 들어간 이름 지정한거 -->
			<tr>
				<td>${vo.memberId }</td>
				<td><a href="detail?boardId=${vo.boardId }&page=${pageMaker.criteria.page }"
					   class="text-dark">${vo.boardTitle }</a></td>
				<fmt:formatDate value="${vo.boardDateCreated }"
				pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
				<td>${boardDateCreated }</td>
				<td>${vo.replyCnt }</td>
				<td>
					<span id="heart" class="animated-heart">&#x2764;</span>
					(${vo.heartCnt })
				</td>
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
	
	<form action="search" method="GET">
		<div>
			<label for="saerchType">검색유형</label>
			<select name="searchType" id="searchType">
				<option value="titleOrContent">제목 또는 내용</option>
				<option value="memberId">작성자</option>
			</select>
		</div>
		<div>
			<label for="keyword">키워드</label>
			<input type="text" name="keyword" id="keyword" placeholder="검색어 입력">
		</div>
		<div>
			<button type="submit">검색</button>
		</div>
	
	</form>
	
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
		} else if(result == 'loginSuccess') {
			alert('로그인 성공')
		} else if(result == 'logoutSuccess') {
			alert('로그아웃 성공')
		} else if(result == 'deleteSuccess'){
			alert('회원탈퇴 완료')
		}
		
		//if(result != null && result != "") 방법 2
			
		//<c:if test="${not empty result}"> 방법 3
		//	alert("${result}");
		//</c:if>
		
	</script>
	
</body>
</html>
 