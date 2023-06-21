<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<nav>
    <a href="/board/hotel/list"><img src="<spring:url value="/resources/hotelImg/modoo.PNG"/>"></a>
    <div>
        <ul>
            <c:if test="${not empty sessionScope.memberId}">
                <li>${sessionScope.memberId }님, 반갑습니다!</li>
                <li><a href="/board/member/logout">로그아웃</a></li>
                <li><a href="/board/member/mypage">마이페이지</a></li>
            </c:if>
            <c:if test="${empty sessionScope.memberId}">
                <li><a href="login">로그인</a></li>
                <li><a href="/board/member/register">회원가입</a></li>
            </c:if>
            <li><a href="/board/board/list">게시판</a></li>
        </ul>
    </div>
</nav>

<h1>여행사 정보</h1>


<div>
    <c:forEach var="vo" items="${list}">
        <div>
            <a href="detail?hotelId=${vo.hotelId}&amp;page=${pageMaker.criteria.page}">
                <img src="<spring:url value='${vo.hotelImg}'/>">
            </a>
            <h3>${vo.hotelName}</h3>
            <p>${vo.reviewCnt}개의 리뷰</p>
            <p>별점 평균 (${vo.hotelStarAvg}/5)</p>
            
            <a href="detail?hotelId=${vo.hotelId}&amp;page=${pageMaker.criteria.page}">자세히 보기</a>
        </div>
    </c:forEach>
</div>
<hr>
<form method="GET">
    <div>
        <label for="keyword">여행사 검색 :</label>
        <input type="text" id="keyword" name="keyword">
        <button type="submit">검색</button>
    </div>
</form>

</body>
</html>