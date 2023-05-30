<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
.container {
    max-width: 400px;
}
</style>
</head>
<body>
	<div class="container">
	<h1 class="mt-5">아이디 찾기</h1>
	<form id="find-member-id" action="find-memberId" method="POST" class="mt-4">
		<div class="form-group">
			<label for="memberName">이름:</label>
			<input type="text" id="memberName" name="memberName" class="form-control" required>
		</div>
		<div class="form-group">
			<label for="memberPhone">전화번호:</label>
			<input type="text" id="memberPhone" name="memberPhone" class="form-control" required>
		</div>
		<div class="form-group">
			<label for="memberEmail">이메일:</label>
			<input type="text" id="memberEmail" name="memberEmail" class="form-control" required>
		</div>
		<button type="submit" class="btn btn-primary">아이디 찾기</button>
	</form>
	
	<a href="login" class="mt-4">로그인 화면으로</a>

	<div id="resultMsg" class="mt-4"></div>
</div>
	
	<!-- Bootstrap JS -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			
			$('#find-member-id').on('submit', function(event){
				event.preventDefault();
				
				var formData = $(this).serialize(); // 폼 데이터 직렬화
				
				$.ajax({
					type : 'POST',
					url : 'find-memberId',
		            data : formData,
					success : function(result) {
						var resultMsg = '';
						if (result != null && result != '') {
							console.log(result);
							var resultMsg = '<p>회원님의 아이디는 : ' + result + ' 입니다.</p>';
						} else {
							var resultMsg = '<p>일치하는 정보가 없습니다</p>'
						}
						$('#resultMsg').html(resultMsg);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log('AJAX Error:', textStatus, errorThrown);
					}
				}); // end ajax()
				
			}); // end find-member-id on.click()
			
		}); // end document
	</script>

</body>
</html>