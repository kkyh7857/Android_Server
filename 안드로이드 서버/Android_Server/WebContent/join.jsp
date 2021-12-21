<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3> 회원가입 </h3>
	<form action="JoinService" method="post">
		아이디: <input type="text" name="id"><br>
		비밀번호: <input type="password" name="pw"><br>
		닉네임: <input type="text" name="nick"><br>
		전화번호: <input type="text" name="phone"><br>
		<input type="submit" value = "회원가입">
	</form>
</body>
</html>