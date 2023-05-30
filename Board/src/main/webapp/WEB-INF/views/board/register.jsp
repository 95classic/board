<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
<style>
	body {
		background-color: #f9f6e8;
		margin: 0;
		padding: 20px;
	}

	h2 {
		color: #ffa500;
		text-align: center;
	}

	form {
		background-color: #fff;
		max-width: 600px;
		margin: 0 auto;
		padding: 20px;
		border-radius: 8px;
		box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
	}

	form div {
		margin-bottom: 20px;
	}

	form div p {
		margin: 0;
		font-weight: bold;
		color: #ffa500;
	}

	form input[type="text"],
	form textarea {
		width: 100%;
		padding: 10px;
		border: 1px solid #ccc;
		border-radius: 4px;
	}

	form input[type="submit"] {
		background-color: #ffa500;
		color: #fff;
		border: none;
		padding: 10px 20px;
		border-radius: 4px;
		cursor: pointer;
	}

	form input[type="submit"]:hover {
		background-color: #ff8c00;
	}
</style>
</head>
<body>
	<h2>글 작성 페이지</h2>
	<form action="register" method="POST">
		<div>
			<p>제목 : </p>
			<input type="text" name="boardTitle" placeholder="재목 입력" required>
		</div>
		<div>
			<p>작성자 : </p>
			<input type="text" name="memberId" value="${sessionScope.memberId }" readonly>
		</div>
		<div>
			<p>내용 : </p>
			<textarea rows="20" cols="120" name="boardContent" placeholder="내용 입력" required></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	
	</form>
</body>
</html>