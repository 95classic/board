<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
<!-- 부트스트랩 CSS 링크 추가 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
	<a href="/board"><img
		src="<spring:url value="/resources/hotelImg/main.png"/>" alt="Logo"></a>
	<div class="container">
		<h1>자유 게시판</h1>
		<a href="register"><button type="button"
				class="btn btn-primary mb-3">글 작성</button></a>
		<table>
			<thead>
				<tr>
					<th style="width: 120px">작성자</th>
					<th style="width: 500px">제목</th>
					<th style="width: 130px">작성일</th>
					<th style="width: 80px">댓글수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.memberId}</td>
						<td><a
							href="detail?boardId=${vo.boardId}&page=${pageMaker.criteria.page}"
							class="text-dark">${vo.boardTitle}</a></td>
						<fmt:formatDate value="${vo.boardDateCreated}"
							pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated" />
						<td>${boardDateCreated}</td>
						<td>${vo.replyCnt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination">
			<c:if test="${pageMaker.hasPrev}">
				<li class="page-item"><a class="page-link"
					href="list?page=${pageMaker.startPageNo - 1}">이전</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPageNo}"
				end="${pageMaker.endPageNo}" var="num">
				<li class="page-item"><a class="page-link"
					href="list?page=${num}">${num}</a></li>
			</c:forEach>
			<c:if test="${pageMaker.hasNext}">
				<li class="page-item"><a class="page-link"
					href="list?page=${pageMaker.endPageNo + 1}">다음</a></li>
			</c:if>
		</ul>

		<form action="search" method="GET" class="my-4">
			<div class="row justify-content-center">
				<div class="col-sm-10 col-md-8 col-lg-6">
					<div class="input-group">
						<select name="searchType" class="custom-select">
							<option value="titleOrContent">제목 또는 내용</option>
							<option value="memberId">작성자</option>
						</select> <input type="text" name="keyword" class="form-control"
							placeholder="검색어 입력">
						<div class="input-group-append">
							<button type="submit" class="btn btn-primary">검색</button>
						</div>
					</div>
				</div>
			</div>
		</form>


		<!-- BoardController -> registerPOST()에서 보낸 데이터 저장 -->
		<input type="hidden" id="alert" value="${result }">
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		var result = $('#alert').val();
		if (result == 'registerSuccess') {
			alert('게시글 작성 성공!');
		} else if (result == 'deleteSuccess') {
			alert('게시글 삭제 성공!');
		} else if (result == 'updateSuccess') {
			alert('게시글 수정 성공!');
		}
	</script>

</body>
</html>