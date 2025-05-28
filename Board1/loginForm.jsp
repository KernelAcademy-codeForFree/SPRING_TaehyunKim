<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
<html>
	<head>
		<meta charset="utf-8">
		<title>loginForm</title>
		<style>
			* {box-sizing:border-box;}
		</style>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/loginForm" method="post">
		<label for="id">아이디: </label>
		<input type="text" name="id" id="id" value="${saveId}" placeholder="아이디를 입력해라" required><br>
		<label for="pwd">비밀번호: </label>
		<input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력해라" required><br>
		<input type="submit" name="login" value="로그인"><br>
		<input type="checkbox" name="checkbox">아이디 기억
		<span> | </span>
		<a href="">비밀번호 찾기</a>
		<span> | </span>
		<a href="">회원가입</a>
	</body>
</html>