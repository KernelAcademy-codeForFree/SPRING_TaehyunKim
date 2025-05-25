<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
	
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
	<!--<form action="userInfo.jsp" method="post">-->
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" value="${saveId}"><br>
	<label for="pwd">패스워드</label>
	<input type="password" name="pwd" id="pwd"><br>
	<input type="checkbox" name="checkbox" checked="checked">아이디 기억<br>
	<input type="submit" name="submit" id="submit" value="로그인">
</form>
</body>
</html>
