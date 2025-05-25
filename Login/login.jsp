<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
	
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
<form action="login" method="post">
	<label for="id">아이디</label><br>
<input type="text" name="id" value="${saveId}"><br>
<label for="password">비밀번호</label><br>
<input type="password" name="password"><br>
<input type="checkbox" name="rememberId"
        ${not empty saveId ? "checked" : ""}>아이디 저장<br>
<input type="submit" value="로그인"><br>
</form>
</body>
</html>
