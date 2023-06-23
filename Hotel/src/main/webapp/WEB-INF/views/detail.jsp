<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.hotelName}</title>
<!-- Font Awesome 아이콘 라이브러리 추가 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Datepicker CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<!-- Datepicker JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<!-- 날짜 파싱해주는 CDN -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<!-- 구글 지도 API -->
<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB8x4ZYP-HkbuTnJlCUTeURnm1VahUao0Q&callback=initMap"
  ></script>
<style type="text/css">
@keyframes heartbeat {
	0% {
		transform: scale(1);
	}

	50% {
		transform: scale(1.5);
	}

	100% {
		transform: scale(1);
	}
}
.animated-heart {
	animation: heartbeat 1s infinite;
}

.red-heart {
	color: red;
}

#heartBtn {
	display: flex;
	justify-content: center;
	cursor: pointer;
}

#heartIcon {
	font-size: 30px;
}

#heartBtn:hover #heartIcon {
	color: red; /* 마우스 호버 시 색상을 빨간색으로 변경 */
	cursor: pointer;
}

body {
	background-color: WhiteSmoke;
}

#star-rating {
		font-size: 30px;
		color: #cccccc;
	}

	.star {
		display: inline-block;
		margin-right: 5px;
		color: #cccccc;
		transition: color 0.3s;
		cursor: pointer;
		font-size: 40px;
		text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
	}

	.star:hover,
	.star.active {
		color: #ffcc00;
		transform: scale(1.2);
		animation: pulse 1s infinite;
	}

	@keyframes pulse {
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
#roomInformation {
	font-size: 30px;
}

.table-container {
	border: 1px solid #ccc;
	padding: 10px;
	max-width: 500px;
	margin: 0 auto;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 10px 0;
}

th, td {
	padding: 10px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}


a.selectRoom {
	text-decoration: none; /* 밑줄 없애기 */
	color: #0066cc;
	cursor: pointer;
}

h2, h3, p {
	font-family: Arial, sans-serif;
	color: #333;
	text-align: center;
	margin: 10px 0;
}

h2 {
	font-size: 2em;
	margin-top: 50px;
}

h3 {
	font-size: 1.5em;
}

img {
	display: block;
	margin: 0 auto;
	height: auto;
}

textarea {
	display: block;
	margin: 0 auto;
	width: 100%;
	max-width: 700px;
	font-family: Arial, sans-serif;
	font-size: 1.1em;
	border: 1px solid #ccc;
	padding: 5px;
}

#listBtn {
	display: block;
	margin: 30px auto;
	font-family: Arial, sans-serif;
	font-size: 1.2em;
	padding: 10px 20px;
	border: none;
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
	border-radius: 5px;
}

#listBtn:hover {
	background-color: #0056b3;
}

form {
	max-width: 800px;
	margin: 0 auto;
	font-family: Arial, sans-serif;
	font-size: 1.1em;
	border: 1px solid #ccc;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 0px 5px #ccc;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 5px;
}

.custom-textarea {
	font-family: Arial, sans-serif;
	font-size: 16px;
}

.centered-container {
	justify-content: center;
	align-items: center;
}

.form-group {
	margin-bottom: 10px;
}

#btn_add {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	font-size: 16px;
}

.container {
	max-width: 500px;
}
.logged-in {
	background-color: #f2f2f2;
	padding: 10px;
	border-radius: 5px;
	text-align: center;
}

.welcome-message {
	font-size: 18px;
	color: #333333;
	margin-bottom: 10px;
}

.logout-link {
	text-decoration: none;
}

.logout-button {
	background-color: #0000FF;
	color: #ffffff;
	border: none;
	padding: 8px 16px;
	border-radius: 5px;
	cursor: pointer;
}

.logout-button:hover {
	background-color: #ffa500;
}
.logged-out {
	background-color: #f2f2f2;
	padding: 10px;
	border-radius: 5px;
	text-align: center;
}

.message {
	font-size: 18px;
	color: #333333;
	margin-bottom: 10px;
}

.login-link {
	text-decoration: none;
}

.login-button {
	background-color: #ffcc00;
	color: #ffffff;
	border: none;
	padding: 8px 16px;
	border-radius: 5px;
	cursor: pointer;
}

.login-button:hover {
	background-color: #0000FF;
}
@keyframes rotating {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(2000deg); }
}

.reviewStar {
	font-size : 17px;
	display: inline-block; /* 별을 인라인 요소로 표시 */
  	animation: rotating 5s linear infinite;
}

</style>
</head>
<body>
<c:if test="${not empty sessionScope.memberId }">
	<div class="logged-in">
		<p class="welcome-message">${sessionScope.memberId }님 로그인 중</p>
		<a href="member/logout" class="logout-link">
			<button class="logout-button">로그아웃</button>
		</a>
	</div>
</c:if>
<c:if test="${empty sessionScope.memberId }">
	<div class="logged-out">
		<p class="message">현재 비로그인 상태입니다.</p>
		<a href="member/login" class="login-link">
			<button class="login-button">로그인</button>
		</a>
	</div>
</c:if>
	<a href="/hotel"><img
		src="<spring:url value="/resources/hotelImg/main.png"/>"></a>
	<a href="./?page=${page}"><button id="listBtn">호텔목록</button></a>
	<img style="width: 500px; height: auto;" src="<spring:url value='${hvo.hotelImg }'/>"><br>
	
	<span id="heartBtn">
  		<i id="heartIcon" class="far fa-heart"></i>
	</span>
	
	<input type="hidden" id="hotelId" value="${hvo.hotelId }">
	<h2>호텔명 : ${hvo.hotelName}</h2>
	<h3>별점 평균 (${hvo.hotelReviewAvg } / 5)</h3>
	<br>
	<p style="font-size : 20px;">위치 : ${hvo.hotelAddress }</p>
	
	<div id="map" 
	style="width: 700px; height: 600px; margin: 0 auto;
        display: block; margin-bottom: 15px;">
    </div>
	
	<script type="text/javascript">
		window.initMap = function () {
        const geocoder = new google.maps.Geocoder();
        const mapElement = document.getElementById("map");

        // 호텔 주소를 위경도 좌표로 변환하여 지도에 표시
        geocoder.geocode({ address: "${hvo.hotelAddress}" }, function (results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                const hotelLocation = results[0].geometry.location;

                const map = new google.maps.Map(mapElement, {
                    center: hotelLocation,
                    zoom: 16,
                });

                // 마커 추가
                new google.maps.Marker({
                    position: hotelLocation,
                    map: map,
                    title: "${hvo.hotelName}",
                });
            } else {
                console.error("Geocode was not successful for the following reason: " + status);
            }
        });
    }
	</script>

	<div>
		 <textarea rows="30" cols="100" readonly class="form-control custom-textarea">${hvo.hotelContent}</textarea>
	</div>

	<h3>${hvo.hotelName } 객실 목록</h3>
	<div class="table-container">
		<table>
			<thead>
				<tr>
					<th>객실 종류</th>
					<th>객실 가격(원)</th>
					<th>남은 객실 수</th>
					<th>예약</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.roomName }</td>
						<td>${vo.roomPrice }</td>
						<td>${vo.roomCnt }</td>
						<c:if test="${vo.roomCnt != 0 }">
							<td><input type="hidden" class="roomId" value="${vo.roomId }">
							<a class="selectRoom"><button>선택</button></a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<c:if test="${not empty sessionScope.memberId }">
		<!-- <h2>예약하기(객실을 먼저 선택해주세요!)</h2> -->
		<form id="reservation-form" action="member/createReservation"
			method="POST" style="display: none;">
			<input type="hidden" name="hotelId" value="${hvo.hotelId }">
			<input type="hidden" name="memberId"
				value="${sessionScope.memberId }"> <input type="hidden"
				name="reservationHotelName" value="${hvo.hotelName }">
			<div id="roomInformation"></div>

			<div class="row">
				<div class="col-sm-2">
					<label for="startDate">체크인 날짜</label>
					<div class="input-group date" data-provide="datepicker">
						<input type="text" class="form-control" name="reservationCheckIn"
							id="reservationCheckIn" required>
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</div>
					</div>
				</div>
				<div class="col-sm-2">
					<label for="endDate">체크아웃 날짜</label>
					<div class="input-group date" data-provide="datepicker">
						<input type="text" class="form-control" name="reservationCheckOut"
							id="reservationCheckOut" required>
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</div>
					</div>
				</div>
			</div>
			<br><input type="submit" value="예약하기" class="btn btn-info">
		</form>

		<h2>리뷰 작성</h2>
		<h3 class="text-center">별점을 매겨주세요!</h3>
		<div id="star-rating" class="text-center">
			<span class="star" style="font-size: 50px;">&#9733;</span> <span
				class="star" style="font-size: 45px;">&#9733;</span> <span
				class="star" style="font-size: 40px;">&#9733;</span> <span
				class="star" style="font-size: 45px;">&#9733;</span> <span
				class="star" style="font-size: 50px;">&#9733;</span>
		</div>


		<div class="centered-container">
			<div class="container">
				<div class="d-flex">
					<div class="form-group">
						<input type="text" id="memberId" value="${sessionScope.memberId}"
							readonly class="form-control">
					</div>
					<div class="form-group">
						<input type="text" id="reviewContent" class="form-control">
					</div>
					<div class="form-group">
						<button id="btn_add">작성</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${empty sessionScope.memberId }">
		<div class="text-center">
			<p>
				리뷰는 로그인이 필요한 기능입니다. <a href="./login" class="btn btn-primary">로그인하기</a>
			</p>
			<p>
				예약은 로그인이 필요한 기능입니다. <a href="./login" class="btn btn-primary">로그인하기</a>
			</p>
		</div>
	</c:if>

	<h2>전체 리뷰</h2>
	<hr>
	<div>
		<div id="reviews"></div>
	</div>

	<input type="hidden" id="hotelId" value="${vo.hotelId }">

	<script type="text/javascript">
      $(document).ready(function(){
    	 console.log($('#heartBtn').val());
         getAllReviews();
         getHeart();

         // 별점 계산 함수
         var reviewStar = 0; // 초기 별점 0점
 		  $('.star').click(function() {
 		    $(this).addClass('active');
 		    $(this).prevAll().addClass('active');
 		    $(this).nextAll().removeClass('active');
 		    reviewStar = $(this).index() + 1; // 클릭한 별점의 인덱스를 기준으로 별점 계산
 		    console.log(reviewStar); // 콘솔창에 별점이 출력됨
 		  });
         
         $('#btn_add').click(function(){
            var hotelId = $('#hotelId').val(); // 호텔 번호 데이터
            var memberId = $('#memberId').val(); // 작성자 데이터
            var reviewContent = $('#reviewContent').val(); // 리뷰 내용
            var obj = {
                  'hotelId' : hotelId,
                  'memberId' : memberId,
                  'reviewContent' : reviewContent,
                  'reviewStar' : reviewStar
            }
            
            // $.ajax로 송수신
            $.ajax({
               type : 'POST', 
               url : 'reviews',
               headers : {
                  'Content-Type' : 'application/json'
               }, 
               data : JSON.stringify(obj), // JSON으로 변환
               success : function(result) {
                  if(result == 1) {
                     alert('리뷰 입력 성공');
                     getAllReviews();
                     $('#reviewContent').val(''); // 입력 후 input 비우기
                  }
               }
            });
         }); // end btn_add.click()
         
         // 호텔 리뷰 전체 가져오기
         function getAllReviews() {
            var hotelId = $('#hotelId').val();
            
            var url = 'reviews/all/' + hotelId;
            $.getJSON(
               url,
               function(data){
                  // data : 서버에서 전송받은 list 데이터가 저장되어 있음
                  // getJSON()에서 json 데이터는
                  // javascript object로 자동 parsing됨
               
                  var memberId = $('#memberId').val();
                  var list = ''; // 리뷰 데이터를 HTML에 표현할 문자열 변수
               
                  // $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
                  $(data).each(function(){
                     // this : 컬렉션의 각 인덱스 데이터를 의미
                     var reviewDate = moment(this.reviewDateCreated).format('YYYY-MM-DD HH:mm:ss'); 
                     // moment = 시간 날짜를 파싱 해주는 객체 (라이브러리 추가)
                  
                     var hidden = 'hidden';
                     var readonly = 'readonly';
                     
                     // 별점 숫자 값에 따라 ★로 변환
                     var starHtml = '';
                     for (var i = 0; i < this.reviewStar; i++) {
                    		 starHtml += '<span class="reviewStar">&#9733;</span>';
                     }
                     
                     if(memberId == this.memberId) { 
                        hidden = '';
                        readonly = '';
                     }
                     
                     list += '<div class="review_item">'
                        + '<pre>'
                        + '<input type="hidden" id="reviewId" value="'+ this.reviewId +'">'
                        + '별점 ' + starHtml + '<br>' + this.memberId + '님의 리뷰 : '
                        + '&nbsp;&nbsp;' // 공백
                        + '<input type="text" ' + readonly + ' id="reviewContent" value="'+ this.reviewContent +'">'
                        + '<br>'
                        + reviewDate
                        + '&nbsp;&nbsp;'
                        + '<button class="btn_update" ' + hidden + '>수정</button>'
                        + '<button class="btn_delete" ' + hidden + '>삭제</button>'
                        + '</pre>'
                        + '</div>';
                  }); // end each()
                  $('#reviews').html(list);
               } // end function()
            );// end getJSON()
         } // end getAllReplies()
         
         // 수정 버튼을 클릭하면 선택된 리뷰 수정
         $('#reviews').on('click', '.review_item .btn_update', function(){
            console.log(this);
            
            // 선택된 리뷰의 reviewId, reviewContent 값을 저장
            // preAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
            var reviewId = $(this).prevAll('#reviewId').val();
            var reviewContent = $(this).prevAll('#reviewContent').val();
            console.log("선택된 리뷰 번호 : " + reviewId + ", 리뷰 내용 : " + reviewContent);
            
            // ajax요청
            $.ajax({
               type : 'PUT',
               url : 'reviews/' + reviewId,
               headers : {
                  'Content-Type' : 'application/json'
               },
               data : JSON.stringify({
                  reviewId : reviewId,
                  reviewContent : reviewContent
                  }),
               success : function(result) {
                  console.log(result);
                  if(result == 1) {
                     alert('댓글 수정 성공!');
                  getAllReviews();
                  }
               }
               
            }); // end ajax()
         });// end replies.on()
         
         // 삭제 버튼을 클릭하면 선택된 리뷰 삭제
         $('#reviews').on('click', '.review_item .btn_delete', function(){
            console.log(this);
            var hotelId = $('#hotelId').val();
            var reviewId = $(this).prevAll('#reviewId').val();
            
            // ajax 요청
            $.ajax({
               type : 'DELETE',
               url : 'reviews/' + reviewId,
               headers : {
                  'Content-Type' : 'application/json'
               },
               data : hotelId,
               success : function(result) {
                  console.log(result);
                  if(result == 1) {
                     alert('리뷰 삭제 성공!');
                     getAllReviews();
                  }
               }
            }); // end ajax
         }); // end on.click()
         
         
      	 // 방 클릭했을 시 그 방에대한 정보 출력
         $('.selectRoom').click(function(){
        	 	var roomId = $(this).prev('.roomId').val();
        	    getRoomById(roomId);
        	    $('#reservation-form').css('display', 'block');
        	}); // end selectRoom.click() 

        	function getRoomById(roomId) {
        	    console.log(roomId);
        	    
        	    $.ajax({
        	        url : 'room/' + roomId,
        	        type : 'GET',
        	        success : function(data) {
        	            console.log(data);
        	            
        	            var selectRoom =
        	                '<div class="form-group">' +
        	                '<input type="hidden" name="roomId" value="' + data.roomId + '">' +
        	                '<label for="reservationRoomName">객실 종류</label>' +
        	                '<input type="text" class="form-control" id="reservationRoomName" name="reservationRoomName" readonly value="' + data.roomName + '">' +
        	                '</div>' +
        	                '<div class="form-group">' +
        	                '<label for="roomPrice">1박당 가격(원)</label>' +
        	                '<input type="text" class="form-control" id="roomPrice" name="roomPrice" readonly value="' + data.roomPrice + '">' +
        	                '</div>' +
        	                '<input type="hidden" name="totalPrice">';	     
        	            $('#roomInformation').html(selectRoom);
        	        },
        	        error: function(jqXHR, textStatus, errorThrown) {
        	            console.log(textStatus, errorThrown);
        	        }
        	    }); // end ajax
        	} // end getRoomById()
         
     	 // datepicker() 메서드 호출
         $( function() {
             $(".reservationCheckIn").datepicker();
             $(".reservationCheckOut").datepicker();
         } );
     	 
         $(function() {
        	  // 체크인/체크아웃 날짜의 차이 계산
        	  $('#reservationCheckIn, #reservationCheckOut').change(function() {
        	    var checkInDate = new Date($('#reservationCheckIn').val());
        	    var checkOutDate = new Date($('#reservationCheckOut').val());
        	    var nights = Math.floor((checkOutDate - checkInDate) / (1000 * 60 * 60 * 24));

        	    // 예약 금액 계산
        	    var totalPrice = nights * $('#roomPrice').val();
        	    if (totalPrice <= 0) {
        	    	alert('날짜를 정확히 지정해주세요!');
        	    	location.href = location.href;
        	    } else {
        	    	$('input[name=totalPrice]').val(totalPrice);
        	    }
        	  });
        	}); 
         
         // 하트 버튼 클릭 했을 때
         $('#heartBtn').click(function() {
        	 var memberId = $('#memberId').val();
        	 // 로그인 상태 여부 판단 후 좋아요 기능 작동
        	 if (memberId != null) {
        		 if ($('#heartIcon').hasClass('far')) { 
             	    var hotelId = $('#hotelId').val();
             	    var memberId = $('#memberId').val();
             	    var obj = {
             	      'hotelId': hotelId,
             	      'memberId': memberId
             	    }
             	    $.ajax({
             	      type: 'POST',
             	      url: 'heart',
             	      headers: {
             	        'Content-Type': 'application/json'
             	      },
             	      data: JSON.stringify(obj),
             	      success: function(result) {
             	        console.log(result);
             	        if (result == 1) {
             	          $('#heartIcon').removeClass('far').addClass('fas animated-heart red-heart');
             	        }
             	      }
             	    }); // end ajax
             	  } else {
             	    var hotelId = $('#hotelId').val();
             	    var memberId = $('#memberId').val();
             	    $.ajax({
             	      type: 'DELETE',
             	      url: 'heart/' + hotelId,
             	      headers: {
             	        'Content-Type': 'application/json'
             	      },
             	      data: memberId,
             	      success: function(result) {
             	        console.log(result);
             	        if (result >= 1) {
             	          $('#heartIcon').removeClass('fas animated-heart red-heart').addClass('far');
             	        }
             	      }
             	    }); // end ajax
             	  }
        	 } else {
        		 alert('로그인 후 이용해주세요!');
        		 location.href = 'member/login';
        	 }
        	}); // end heartBtn.click()

        	function getHeart() {
        	  var hotelId = $('#hotelId').val();
        	  var memberId = $('#memberId').val();
        	  $.ajax({
        	    type: 'GET',
        	    url: 'heart/all/' + hotelId + '?memberId=' + memberId,
        	    success: function(result) {
        	      console.log(result);
        	      if (result == 0) {
        	        $('#heartIcon').removeClass('fas animated-heart red-heart').addClass('far');
        	      } else {
        	        $('#heartIcon').removeClass('far').addClass('fas animated-heart red-heart');
        	      }
        	    }
        	  }); // end ajax
        	} // end getHeart()
     	 
      }); // end document
   </script>
   
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>